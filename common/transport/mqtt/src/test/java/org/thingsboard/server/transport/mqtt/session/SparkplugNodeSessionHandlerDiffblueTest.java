/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.transport.mqtt.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.CacheProvider;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.cfg.DefaultCacheProvider;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.protobuf.Any;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttQoS;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import org.eclipse.leshan.core.ResponseCode;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.common.data.TransportPayloadType;
import org.thingsboard.server.common.data.exception.ThingsboardErrorCode;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.MqttTransportHandler;
import org.thingsboard.server.transport.mqtt.adaptors.JsonMqttAdaptor;
import org.thingsboard.server.transport.mqtt.adaptors.MqttTransportAdaptor;
import org.thingsboard.server.transport.mqtt.gateway.GatewayMetricsService;
import org.thingsboard.server.transport.mqtt.util.sparkplug.SparkplugMessageType;
import org.thingsboard.server.transport.mqtt.util.sparkplug.SparkplugTopic;

class SparkplugNodeSessionHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link SparkplugNodeSessionHandler#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToPostTelemetry() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    UUID sessionId2 = UUID.randomUUID();
    SparkplugNodeSessionHandler sparkplugNodeSessionHandler = new SparkplugNodeSessionHandler(null, deviceSessionCtx,
        sessionId2, true, new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH));
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getTelemetryDynamicMsgDescriptor()).thenReturn(Any.getDescriptor());
    ByteBuf byteBuf = mock(ByteBuf.class);
    when(byteBuf.readableBytes()).thenReturn(1);
    when(byteBuf.readerIndex()).thenReturn(1);
    when(byteBuf.getBytes(anyInt(), Mockito.<byte[]>any()))
        .thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));
    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(byteBuf);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> sparkplugNodeSessionHandler.convertToPostTelemetry(ctx, inbound));
    verify(byteBuf).getBytes(eq(1), isA(byte[].class));
    verify(byteBuf).readableBytes();
    verify(byteBuf).readerIndex();
    verify(inbound).payload();
    verify(ctx).getTelemetryDynamicMsgDescriptor();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugNodeSessionHandler#getNodeBirthMetrics()}
   *   <li>{@link SparkplugNodeSessionHandler#getSparkplugTopicNode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode = new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler = new SparkplugNodeSessionHandler(null, deviceSessionCtx,
        sessionId2, true, sparkplugTopicNode);

    // Act
    Map<String, SparkplugBProto.Payload.Metric> actualNodeBirthMetrics = sparkplugNodeSessionHandler
        .getNodeBirthMetrics();
    SparkplugTopic actualSparkplugTopicNode = sparkplugNodeSessionHandler.getSparkplugTopicNode();

    // Assert
    assertTrue(actualNodeBirthMetrics.isEmpty());
    assertSame(sparkplugTopicNode, actualSparkplugTopicNode);
  }

  /**
   * Method under test:
   * {@link SparkplugNodeSessionHandler#SparkplugNodeSessionHandler(MqttTransportHandler, DeviceSessionCtx, UUID, boolean, SparkplugTopic)}
   */
  @Test
  void testNewSparkplugNodeSessionHandler() throws MissingResourceException {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode = new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    // Act
    SparkplugNodeSessionHandler actualSparkplugNodeSessionHandler = new SparkplugNodeSessionHandler(parent,
        deviceSessionCtx, sessionId2, true, sparkplugTopicNode);

    // Assert
    MqttTransportContext mqttTransportContext = actualSparkplugNodeSessionHandler.context;
    ObjectMapper mapper = mqttTransportContext.getMapper();
    SerializationConfig serializationConfig = mapper.getSerializationConfig();
    assertTrue(serializationConfig.getDefaultPrettyPrinter() instanceof DefaultPrettyPrinter);
    JsonFactory factory = mapper.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    DeserializationConfig deserializationConfig = mapper.getDeserializationConfig();
    ContextAttributes attributes = deserializationConfig.getAttributes();
    assertTrue(attributes instanceof ContextAttributes.Impl);
    CacheProvider cacheProvider = deserializationConfig.getCacheProvider();
    assertTrue(cacheProvider instanceof DefaultCacheProvider);
    DeserializationContext deserializationContext = mapper.getDeserializationContext();
    DeserializerFactory factory2 = deserializationContext.getFactory();
    assertTrue(factory2 instanceof BeanDeserializerFactory);
    assertTrue(deserializationContext instanceof DefaultDeserializationContext.Impl);
    ClassIntrospector classIntrospector = deserializationConfig.getClassIntrospector();
    assertTrue(classIntrospector instanceof BasicClassIntrospector);
    AccessorNamingStrategy.Provider accessorNaming = deserializationConfig.getAccessorNaming();
    assertTrue(accessorNaming instanceof DefaultAccessorNamingStrategy.Provider);
    AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
    assertTrue(annotationIntrospector instanceof JacksonAnnotationIntrospector);
    VisibilityChecker<?> visibilityChecker = mapper.getVisibilityChecker();
    assertTrue(visibilityChecker instanceof VisibilityChecker.Std);
    PolymorphicTypeValidator polymorphicTypeValidator = mapper.getPolymorphicTypeValidator();
    assertTrue(polymorphicTypeValidator instanceof LaissezFaireSubTypeValidator);
    SubtypeResolver subtypeResolver = mapper.getSubtypeResolver();
    assertTrue(subtypeResolver instanceof StdSubtypeResolver);
    SerializerFactory serializerFactory = mapper.getSerializerFactory();
    assertTrue(serializerFactory instanceof BeanSerializerFactory);
    SerializerProvider serializerProvider = mapper.getSerializerProvider();
    assertTrue(serializerProvider instanceof DefaultSerializerProvider.Impl);
    SerializerProvider serializerProviderInstance = mapper.getSerializerProviderInstance();
    assertTrue(serializerProviderInstance instanceof DefaultSerializerProvider.Impl);
    JsonSerializer<Object> defaultNullKeySerializer = serializerProvider.getDefaultNullKeySerializer();
    assertTrue(defaultNullKeySerializer instanceof FailingSerializer);
    JsonSerializer<Object> defaultNullValueSerializer = serializerProvider.getDefaultNullValueSerializer();
    assertTrue(defaultNullValueSerializer instanceof NullSerializer);
    DeserializerFactoryConfig factoryConfig = ((BeanDeserializerFactory) factory2).getFactoryConfig();
    Iterable<Deserializers> deserializersResult = factoryConfig.deserializers();
    assertTrue(deserializersResult instanceof ArrayIterator);
    SerializerFactoryConfig factoryConfig2 = ((BeanSerializerFactory) serializerFactory).getFactoryConfig();
    Iterable<Serializers> serializersResult = factoryConfig2.serializers();
    assertTrue(serializersResult instanceof ArrayIterator);
    DateFormat dateFormat = mapper.getDateFormat();
    assertTrue(dateFormat instanceof StdDateFormat);
    DeviceSessionCtx deviceSessionCtx2 = actualSparkplugNodeSessionHandler.deviceSessionCtx;
    Lock msgQueueProcessorLock = deviceSessionCtx2.getMsgQueueProcessorLock();
    assertTrue(msgQueueProcessorLock instanceof ReentrantLock);
    assertEquals(" ", factory.getRootValueSeparator());
    Locale locale = deserializationConfig.getLocale();
    assertEquals("", locale.getCountry());
    assertEquals("", locale.getDisplayCountry());
    assertEquals("", locale.getDisplayScript());
    assertEquals("", locale.getDisplayVariant());
    assertEquals("", locale.getISO3Country());
    assertEquals("", locale.getScript());
    assertEquals("", locale.getVariant());
    TimeZone timeZone = deserializationConfig.getTimeZone();
    assertEquals("Coordinated Universal Time", timeZone.getDisplayName());
    assertEquals("English", locale.getDisplayLanguage());
    assertEquals("English", locale.getDisplayName());
    assertEquals("JSON", factory.getFormatName());
    Base64Variant base64Variant = deserializationConfig.getBase64Variant();
    assertEquals("MIME-NO-LINEFEEDS", base64Variant.getName());
    assertEquals("MIME-NO-LINEFEEDS", base64Variant.toString());
    assertEquals("UTC", timeZone.getID());
    assertEquals("[one of: 'yyyy-MM-dd'T'HH:mm:ss.SSSX', 'EEE, dd MMM yyyy HH:mm:ss zzz' (lenient)]",
        ((StdDateFormat) dateFormat).toPattern());
    Version versionResult = factory.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    Version versionResult2 = mapper.version();
    assertEquals("com.fasterxml.jackson.core", versionResult2.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-core/2.17.2", versionResult.toFullString());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult2.toFullString());
    assertEquals("en", locale.getLanguage());
    assertEquals("eng", locale.getISO3Language());
    assertEquals("jackson-core", versionResult.getArtifactId());
    assertEquals("jackson-databind", versionResult2.getArtifactId());
    assertEquals('=', base64Variant.getPaddingChar());
    assertNull(serializerProvider.getGenerator());
    assertNull(serializerProviderInstance.getGenerator());
    assertNull(deserializationContext.getParser());
    assertNull(factory.getCharacterEscapes());
    assertNull(factory.getInputDecorator());
    assertNull(factory.getOutputDecorator());
    assertNull(deserializationContext.getConfig());
    assertNull(mapper.getInjectableValues());
    assertNull(deserializationContext.getContextualType());
    assertNull(defaultNullKeySerializer.getDelegatee());
    assertNull(defaultNullValueSerializer.getDelegatee());
    assertNull(deserializationConfig.getFullRootName());
    assertNull(serializationConfig.getFullRootName());
    assertNull(mapper.getPropertyNamingStrategy());
    assertNull(deserializationConfig.getPropertyNamingStrategy());
    assertNull(serializationConfig.getPropertyNamingStrategy());
    assertNull(serializerProvider.getConfig());
    assertNull(deserializationConfig.getHandlerInstantiator());
    assertNull(serializationConfig.getHandlerInstantiator());
    assertNull(serializationConfig.getFilterProvider());
    assertNull(serializerProviderInstance.getFilterProvider());
    assertNull(deserializationConfig.getProblemHandlers());
    assertNull(deviceSessionCtx2.getAttributesDynamicMessageDescriptor());
    assertNull(deviceSessionCtx2.getRpcResponseDynamicMessageDescriptor());
    assertNull(deviceSessionCtx2.getTelemetryDynamicMsgDescriptor());
    assertNull(deviceSessionCtx2.getRpcRequestDynamicMessageBuilder());
    assertNull(deviceSessionCtx2.getChannel());
    assertNull(actualSparkplugNodeSessionHandler.channel);
    assertNull(deviceSessionCtx2.getMqttVersion());
    assertNull(mqttTransportContext.getSslHandler());
    assertNull(deserializationConfig.getDefaultMergeable());
    assertNull(serializationConfig.getDefaultMergeable());
    assertNull(factory.getFormatReadFeatureType());
    assertNull(factory.getFormatWriteFeatureType());
    JsonInclude.Value defaultPropertyInclusion = deserializationConfig.getDefaultPropertyInclusion();
    assertNull(defaultPropertyInclusion.getContentFilter());
    assertNull(defaultPropertyInclusion.getValueFilter());
    assertNull(deserializationContext.getActiveView());
    assertNull(serializerProvider.getActiveView());
    assertNull(serializerProviderInstance.getActiveView());
    assertNull(deserializationConfig.getActiveView());
    assertNull(serializationConfig.getActiveView());
    TypeFactory typeFactory = mapper.getTypeFactory();
    assertNull(typeFactory.getClassLoader());
    assertNull(mqttTransportContext.getMaxPayloadSize());
    assertNull(deserializationConfig.getRootName());
    assertNull(serializationConfig.getRootName());
    assertNull(dateFormat.getNumberFormat());
    assertNull(dateFormat.getCalendar());
    assertNull(dateFormat.getTimeZone());
    assertNull(mqttTransportContext.getExecutor());
    assertNull(mqttTransportContext.getOtaPackageDataCache());
    assertNull(deviceSessionCtx2.getDeviceProfile());
    assertNull(deviceSessionCtx2.getDeviceId());
    assertNull(deviceSessionCtx2.getTenantId());
    assertNull(mqttTransportContext.getTransportResourceCache());
    assertNull(mqttTransportContext.getTransportService());
    assertNull(actualSparkplugNodeSessionHandler.transportService);
    assertNull(mqttTransportContext.getTenantProfileCache());
    assertNull(deviceSessionCtx2.getDeviceInfo());
    assertNull(actualSparkplugNodeSessionHandler.gateway);
    assertNull(mqttTransportContext.getRateLimitService());
    assertNull(deviceSessionCtx2.getSessionInfo());
    assertNull(mqttTransportContext.getServiceInfoProvider());
    assertNull(mqttTransportContext.getScheduler());
    assertNull(mqttTransportContext.getSslHandlerProvider());
    assertNull(mqttTransportContext.getJsonMqttAdaptor());
    assertNull(actualSparkplugNodeSessionHandler.getPayloadAdaptor());
    assertNull(deviceSessionCtx2.getPayloadAdaptor());
    assertNull(mqttTransportContext.getProtoMqttAdaptor());
    assertNull(mqttTransportContext.getGatewayMetricsService());
    assertNull(actualSparkplugNodeSessionHandler.gatewayMetricsService);
    assertEquals(0, factory.getFormatGeneratorFeatures());
    assertEquals(0, factory.getFormatParserFeatures());
    assertEquals(0, deserializationContext.getDeserializationFeatures());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(0, ((ReentrantLock) msgQueueProcessorLock).getHoldCount());
    assertEquals(0, ((ReentrantLock) msgQueueProcessorLock).getQueueLength());
    assertEquals(0, mqttTransportContext.getMessageQueueSizePerDeviceLimit());
    assertEquals(0, deviceSessionCtx2.getMsgQueueSize());
    assertEquals(0L, mqttTransportContext.getDisconnectTimeout());
    assertEquals(0L, mqttTransportContext.getTimeout());
    assertEquals(1, factory.getParserFeatures());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(17, versionResult2.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult2.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(2, versionResult2.getPatchLevel());
    assertEquals(2079, factory.getGeneratorFeatures());
    assertEquals(21771068, serializationConfig.getSerializationFeatures());
    assertEquals(31, factory.getFactoryFeatures());
    assertEquals(473998480, deserializationConfig.getDeserializationFeatures());
    JsonNodeFactory nodeFactory = mapper.getNodeFactory();
    assertEquals(9999, nodeFactory.getMaxElementIndexForInsert());
    assertEquals(JsonInclude.Include.ALWAYS, serializationConfig.getSerializationInclusion());
    assertEquals(JsonInclude.Include.USE_DEFAULTS, defaultPropertyInclusion.getContentInclusion());
    assertEquals(JsonInclude.Include.USE_DEFAULTS, defaultPropertyInclusion.getValueInclusion());
    JsonSetter.Value defaultSetterInfo = deserializationConfig.getDefaultSetterInfo();
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getContentNulls());
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getValueNulls());
    assertEquals(TransportPayloadType.JSON, deviceSessionCtx2.getPayloadType());
    assertEquals(TransportPayloadType.JSON, deviceSessionCtx2.getProvisionPayloadType());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult2.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult2.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(versionResult2.isUnknownVersion());
    assertFalse(defaultNullKeySerializer.isUnwrappingSerializer());
    assertFalse(defaultNullValueSerializer.isUnwrappingSerializer());
    assertFalse(factoryConfig.hasAbstractTypeResolvers());
    assertFalse(factoryConfig.hasDeserializerModifiers());
    assertFalse(factoryConfig.hasDeserializers());
    assertFalse(factoryConfig.hasValueInstantiators());
    assertFalse(deserializationConfig.hasExplicitTimeZone());
    assertFalse(serializationConfig.hasExplicitTimeZone());
    assertFalse(factoryConfig2.hasKeySerializers());
    assertFalse(factoryConfig2.hasSerializerModifiers());
    assertFalse(factoryConfig2.hasSerializers());
    assertFalse(((ArrayIterator<Deserializers>) deserializersResult).hasNext());
    assertFalse(((ArrayIterator<Serializers>) serializersResult).hasNext());
    assertFalse(locale.hasExtensions());
    assertFalse(((ReentrantLock) msgQueueProcessorLock).hasQueuedThreads());
    assertFalse(((ReentrantLock) msgQueueProcessorLock).isFair());
    assertFalse(((ReentrantLock) msgQueueProcessorLock).isHeldByCurrentThread());
    assertFalse(((ReentrantLock) msgQueueProcessorLock).isLocked());
    assertFalse(deviceSessionCtx2.isConnected());
    assertFalse(mqttTransportContext.isProxyEnabled());
    assertFalse(mqttTransportContext.isSkipValidityCheckForClientCert());
    assertFalse(deviceSessionCtx2.isDeviceProfileMqttTransportType());
    assertFalse(deviceSessionCtx2.isProvisionOnly());
    assertFalse(deviceSessionCtx2.isSendAckOnValidationException());
    assertTrue(factoryConfig.hasKeyDeserializers());
    assertTrue(deserializationConfig.isAnnotationProcessingEnabled());
    assertTrue(serializationConfig.isAnnotationProcessingEnabled());
    assertTrue(((StdDateFormat) dateFormat).isColonIncludedInTimeZone());
    assertTrue(dateFormat.isLenient());
    assertTrue(deviceSessionCtx2.getMsgQueueSnapshot().isEmpty());
    assertTrue(actualSparkplugNodeSessionHandler.getNodeBirthMetrics().isEmpty());
    assertTrue(actualSparkplugNodeSessionHandler.mqttQoSMap.isEmpty());
    Set<Object> registeredModuleIds = mapper.getRegisteredModuleIds();
    assertTrue(registeredModuleIds.isEmpty());
    assertTrue(actualSparkplugNodeSessionHandler.isJsonPayloadType());
    assertTrue(actualSparkplugNodeSessionHandler.isOverwriteDevicesActivity());
    assertTrue(deviceSessionCtx2.isJsonPayloadType());
    assertEquals(Integer.MAX_VALUE, base64Variant.getMaxLineLength());
    assertEquals('=', base64Variant.getPaddingByte());
    assertSame(sparkplugTopicNode, actualSparkplugNodeSessionHandler.getSparkplugTopicNode());
    assertSame(nodeFactory, deserializationConfig.getNodeFactory());
    assertSame(registeredModuleIds, locale.getExtensionKeys());
    assertSame(registeredModuleIds, locale.getUnicodeLocaleAttributes());
    assertSame(registeredModuleIds, locale.getUnicodeLocaleKeys());
    assertSame(serializationConfig, serializerProviderInstance.getConfig());
    assertSame(typeFactory, serializerProviderInstance.getTypeFactory());
    assertSame(typeFactory, deserializationConfig.getTypeFactory());
    assertSame(typeFactory, serializationConfig.getTypeFactory());
    assertSame(versionResult2, annotationIntrospector.version());
    assertSame(base64Variant, serializationConfig.getBase64Variant());
    assertSame(locale, serializerProviderInstance.getLocale());
    assertSame(locale, serializationConfig.getLocale());
    assertSame(timeZone, serializerProviderInstance.getTimeZone());
    assertSame(timeZone, serializationConfig.getTimeZone());
    assertSame(defaultPropertyInclusion, serializationConfig.getDefaultPropertyInclusion());
    assertSame(defaultSetterInfo, serializationConfig.getDefaultSetterInfo());
    assertSame(mapper, factory.getCodec());
    assertSame(sessionId, deviceSessionCtx2.getSessionId());
    assertSame(sessionId2, actualSparkplugNodeSessionHandler.getSessionId());
    MqttTransportContext mqttTransportContext2 = actualSparkplugNodeSessionHandler.context;
    assertSame(mqttTransportContext2, deviceSessionCtx.getContext());
    assertSame(mqttTransportContext2, deviceSessionCtx2.getContext());
    ConcurrentMap<MqttTopicMatcher, Integer> mqttTopicMatcherIntegerMap = actualSparkplugNodeSessionHandler.mqttQoSMap;
    assertSame(mqttTopicMatcherIntegerMap, deviceSessionCtx.getMqttQoSMap());
    assertSame(mqttTopicMatcherIntegerMap, deviceSessionCtx2.getMqttQoSMap());
    assertSame(factory, mapper.getJsonFactory());
    assertSame(attributes, serializationConfig.getAttributes());
    assertSame(cacheProvider, serializationConfig.getCacheProvider());
    assertSame(classIntrospector, serializationConfig.getClassIntrospector());
    assertSame(accessorNaming, serializationConfig.getAccessorNaming());
    assertSame(annotationIntrospector, serializerProviderInstance.getAnnotationIntrospector());
    assertSame(annotationIntrospector, serializationConfig.getAnnotationIntrospector());
    assertSame(visibilityChecker, deserializationConfig.getDefaultVisibilityChecker());
    assertSame(visibilityChecker, serializationConfig.getDefaultVisibilityChecker());
    assertSame(polymorphicTypeValidator, deserializationConfig.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, serializationConfig.getPolymorphicTypeValidator());
    assertSame(subtypeResolver, deserializationConfig.getSubtypeResolver());
    assertSame(subtypeResolver, serializationConfig.getSubtypeResolver());
    assertSame(defaultNullKeySerializer, serializerProviderInstance.getDefaultNullKeySerializer());
    assertSame(defaultNullValueSerializer, serializerProviderInstance.getDefaultNullValueSerializer());
    assertSame(dateFormat, deserializationConfig.getDateFormat());
    assertSame(dateFormat, serializationConfig.getDateFormat());
  }

  /**
   * Method under test:
   * {@link SparkplugNodeSessionHandler#onAttributesTelemetryProto(int, SparkplugBProto.Payload, SparkplugTopic)}
   */
  @Test
  void testOnAttributesTelemetryProto() throws AdaptorException, ThingsboardException {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getTransportService()).thenReturn(mock(TransportService.class));
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    when(context.getGatewayMetricsService()).thenReturn(new GatewayMetricsService());
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, new ConcurrentHashMap<>(), context);

    UUID sessionId2 = UUID.randomUUID();
    SparkplugNodeSessionHandler sparkplugNodeSessionHandler = new SparkplugNodeSessionHandler(null, deviceSessionCtx,
        sessionId2, true, new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH));
    SparkplugBProto.Payload sparkplugBProto = SparkplugBProto.Payload.getDefaultInstance();
    SparkplugTopic topic = mock(SparkplugTopic.class);
    when(topic.isType(Mockito.<SparkplugMessageType>any())).thenThrow(new RuntimeException("foo"));
    when(topic.isNode()).thenReturn(true);
    when(topic.getNodeDeviceName()).thenReturn("Node Device Name");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> sparkplugNodeSessionHandler.onAttributesTelemetryProto(1, sparkplugBProto, topic));
    verify(context).getTransportService();
    verify(context).getGatewayMetricsService();
    verify(context).getJsonMqttAdaptor();
    verify(topic).getNodeDeviceName();
    verify(topic).isNode();
    verify(topic).isType(eq(SparkplugMessageType.NBIRTH));
  }

  /**
   * Method under test:
   * {@link SparkplugNodeSessionHandler#onDeviceTelemetryProto(ListenableFuture, int, List, String)}
   */
  @Test
  void testOnDeviceTelemetryProto() throws InterruptedException, ExecutionException {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    UUID sessionId2 = UUID.randomUUID();
    SparkplugNodeSessionHandler sparkplugNodeSessionHandler = new SparkplugNodeSessionHandler(parent, deviceSessionCtx,
        sessionId2, true, new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH));
    ListenableFutureTask<MqttDeviceAwareSessionContext> delegate = mock(ListenableFutureTask.class);
    UUID sessionId3 = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap2 = new ConcurrentHashMap<>();
    when(delegate.get()).thenReturn(new DeviceSessionCtx(sessionId3, mqttQoSMap2, new MqttTransportContext()));
    when(delegate.isDone()).thenReturn(true);
    ApiFutureToListenableFuture<MqttDeviceAwareSessionContext> contextListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));

    // Act
    sparkplugNodeSessionHandler.onDeviceTelemetryProto(contextListenableFuture, 1, new ArrayList<>(), "Device Name");

    // Assert that nothing has changed
    verify(delegate).get();
    verify(delegate).isDone();
    verify(function).apply(isA(MqttTopicMatcher.class));
  }

  /**
   * Method under test:
   * {@link SparkplugNodeSessionHandler#onDeviceTelemetryProto(ListenableFuture, int, List, String)}
   */
  @Test
  void testOnDeviceTelemetryProto2() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    UUID sessionId2 = UUID.randomUUID();
    SparkplugNodeSessionHandler sparkplugNodeSessionHandler = new SparkplugNodeSessionHandler(parent, deviceSessionCtx,
        sessionId2, true, new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH));
    ListenableFutureTask<MqttDeviceAwareSessionContext> delegate = mock(ListenableFutureTask.class);
    when(delegate.isDone()).thenReturn(false);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ApiFutureToListenableFuture<MqttDeviceAwareSessionContext> contextListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));

    // Act
    sparkplugNodeSessionHandler.onDeviceTelemetryProto(contextListenableFuture, 1, new ArrayList<>(), "Device Name");

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(delegate).isDone();
    verify(function).apply(isA(MqttTopicMatcher.class));
  }

  /**
   * Method under test:
   * {@link SparkplugNodeSessionHandler#sendErrorRpcResponse(TransportProtos.SessionInfoProto, int, ThingsboardErrorCode, String)}
   */
  @Test
  void testSendErrorRpcResponse() {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    doNothing().when(parent)
        .sendErrorRpcResponse(Mockito.<TransportProtos.SessionInfoProto>any(), anyInt(),
            Mockito.<ThingsboardErrorCode>any(), Mockito.<String>any());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    UUID sessionId2 = UUID.randomUUID();
    SparkplugNodeSessionHandler sparkplugNodeSessionHandler = new SparkplugNodeSessionHandler(parent, deviceSessionCtx,
        sessionId2, true, new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH));

    // Act
    sparkplugNodeSessionHandler.sendErrorRpcResponse(TransportProtos.SessionInfoProto.getDefaultInstance(), 1,
        ThingsboardErrorCode.GENERAL, "An error occurred");

    // Assert that nothing has changed
    verify(parent).sendErrorRpcResponse(isA(TransportProtos.SessionInfoProto.class), eq(1),
        eq(ThingsboardErrorCode.GENERAL), eq("An error occurred"));
  }

  /**
   * Method under test:
   * {@link SparkplugNodeSessionHandler#sendErrorRpcResponse(TransportProtos.SessionInfoProto, int, ThingsboardErrorCode, String)}
   */
  @Test
  void testSendErrorRpcResponse2() {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    doThrow(new RuntimeException("foo")).when(parent)
        .sendErrorRpcResponse(Mockito.<TransportProtos.SessionInfoProto>any(), anyInt(),
            Mockito.<ThingsboardErrorCode>any(), Mockito.<String>any());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    UUID sessionId2 = UUID.randomUUID();
    SparkplugNodeSessionHandler sparkplugNodeSessionHandler = new SparkplugNodeSessionHandler(parent, deviceSessionCtx,
        sessionId2, true, new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> sparkplugNodeSessionHandler.sendErrorRpcResponse(TransportProtos.SessionInfoProto.getDefaultInstance(), 1,
            ThingsboardErrorCode.GENERAL, "An error occurred"));
    verify(parent).sendErrorRpcResponse(isA(TransportProtos.SessionInfoProto.class), eq(1),
        eq(ThingsboardErrorCode.GENERAL), eq("An error occurred"));
  }

  /**
   * Method under test:
   * {@link SparkplugNodeSessionHandler#sendSuccessRpcResponse(TransportProtos.SessionInfoProto, int, ResponseCode, String)}
   */
  @Test
  void testSendSuccessRpcResponse() {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    doNothing().when(parent)
        .sendSuccessRpcResponse(Mockito.<TransportProtos.SessionInfoProto>any(), anyInt(), Mockito.<ResponseCode>any(),
            Mockito.<String>any());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    UUID sessionId2 = UUID.randomUUID();
    SparkplugNodeSessionHandler sparkplugNodeSessionHandler = new SparkplugNodeSessionHandler(parent, deviceSessionCtx,
        sessionId2, true, new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH));
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();

    // Act
    sparkplugNodeSessionHandler.sendSuccessRpcResponse(sessionInfo, 1, ResponseCode.fromCode(1), "Success Msg");

    // Assert that nothing has changed
    verify(parent).sendSuccessRpcResponse(isA(TransportProtos.SessionInfoProto.class), eq(1), isA(ResponseCode.class),
        eq("Success Msg"));
  }

  /**
   * Method under test:
   * {@link SparkplugNodeSessionHandler#sendSuccessRpcResponse(TransportProtos.SessionInfoProto, int, ResponseCode, String)}
   */
  @Test
  void testSendSuccessRpcResponse2() {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    doThrow(new RuntimeException("foo")).when(parent)
        .sendSuccessRpcResponse(Mockito.<TransportProtos.SessionInfoProto>any(), anyInt(), Mockito.<ResponseCode>any(),
            Mockito.<String>any());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    UUID sessionId2 = UUID.randomUUID();
    SparkplugNodeSessionHandler sparkplugNodeSessionHandler = new SparkplugNodeSessionHandler(parent, deviceSessionCtx,
        sessionId2, true, new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH));
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sparkplugNodeSessionHandler.sendSuccessRpcResponse(sessionInfo, 1,
        ResponseCode.fromCode(1), "Success Msg"));
    verify(parent).sendSuccessRpcResponse(isA(TransportProtos.SessionInfoProto.class), eq(1), isA(ResponseCode.class),
        eq("Success Msg"));
  }

  /**
   * Method under test:
   * {@link SparkplugNodeSessionHandler#sendToDeviceRpcRequest(MqttMessage, TransportProtos.ToDeviceRpcRequestMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testSendToDeviceRpcRequest() {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    doNothing().when(parent)
        .sendToDeviceRpcRequest(Mockito.<MqttMessage>any(), Mockito.<TransportProtos.ToDeviceRpcRequestMsg>any(),
            Mockito.<TransportProtos.SessionInfoProto>any());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    UUID sessionId2 = UUID.randomUUID();
    SparkplugNodeSessionHandler sparkplugNodeSessionHandler = new SparkplugNodeSessionHandler(parent, deviceSessionCtx,
        sessionId2, true, new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH));
    MqttMessage payload = new MqttMessage(
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3));
    TransportProtos.ToDeviceRpcRequestMsg rpcRequest = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();

    // Act
    sparkplugNodeSessionHandler.sendToDeviceRpcRequest(payload, rpcRequest,
        TransportProtos.SessionInfoProto.getDefaultInstance());

    // Assert that nothing has changed
    verify(parent).sendToDeviceRpcRequest(isA(MqttMessage.class), isA(TransportProtos.ToDeviceRpcRequestMsg.class),
        isA(TransportProtos.SessionInfoProto.class));
  }

  /**
   * Method under test:
   * {@link SparkplugNodeSessionHandler#sendToDeviceRpcRequest(MqttMessage, TransportProtos.ToDeviceRpcRequestMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testSendToDeviceRpcRequest2() {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    doThrow(new RuntimeException("foo")).when(parent)
        .sendToDeviceRpcRequest(Mockito.<MqttMessage>any(), Mockito.<TransportProtos.ToDeviceRpcRequestMsg>any(),
            Mockito.<TransportProtos.SessionInfoProto>any());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    UUID sessionId2 = UUID.randomUUID();
    SparkplugNodeSessionHandler sparkplugNodeSessionHandler = new SparkplugNodeSessionHandler(parent, deviceSessionCtx,
        sessionId2, true, new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH));
    MqttMessage payload = new MqttMessage(
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3));
    TransportProtos.ToDeviceRpcRequestMsg rpcRequest = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> sparkplugNodeSessionHandler.sendToDeviceRpcRequest(payload, rpcRequest,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(parent).sendToDeviceRpcRequest(isA(MqttMessage.class), isA(TransportProtos.ToDeviceRpcRequestMsg.class),
        isA(TransportProtos.SessionInfoProto.class));
  }
}
