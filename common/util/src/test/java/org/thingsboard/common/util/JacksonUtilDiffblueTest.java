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
package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CacheProvider;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.cfg.DefaultCacheProvider;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
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
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.FloatNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.ResolvedRecursiveType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Deserializers;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Serializers;
import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;

class JacksonUtilDiffblueTest {
  /**
   * Method under test: {@link JacksonUtil#getObjectMapperWithJavaTimeModule()}
   */
  @Test
  void testGetObjectMapperWithJavaTimeModule() throws MissingResourceException {
    // Arrange and Act
    ObjectMapper actualObjectMapperWithJavaTimeModule = JacksonUtil.getObjectMapperWithJavaTimeModule();

    // Assert
    SerializationConfig serializationConfig = actualObjectMapperWithJavaTimeModule.getSerializationConfig();
    assertTrue(serializationConfig.getDefaultPrettyPrinter() instanceof DefaultPrettyPrinter);
    DeserializationConfig deserializationConfig = actualObjectMapperWithJavaTimeModule.getDeserializationConfig();
    ContextAttributes attributes = deserializationConfig.getAttributes();
    assertTrue(attributes instanceof ContextAttributes.Impl);
    CacheProvider cacheProvider = deserializationConfig.getCacheProvider();
    assertTrue(cacheProvider instanceof DefaultCacheProvider);
    DeserializationContext deserializationContext = actualObjectMapperWithJavaTimeModule.getDeserializationContext();
    DeserializerFactory factory = deserializationContext.getFactory();
    assertTrue(factory instanceof BeanDeserializerFactory);
    assertTrue(deserializationContext instanceof DefaultDeserializationContext.Impl);
    ClassIntrospector classIntrospector = deserializationConfig.getClassIntrospector();
    assertTrue(classIntrospector instanceof BasicClassIntrospector);
    AccessorNamingStrategy.Provider accessorNaming = deserializationConfig.getAccessorNaming();
    assertTrue(accessorNaming instanceof DefaultAccessorNamingStrategy.Provider);
    AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
    assertTrue(annotationIntrospector instanceof JacksonAnnotationIntrospector);
    VisibilityChecker<?> visibilityChecker = actualObjectMapperWithJavaTimeModule.getVisibilityChecker();
    assertTrue(visibilityChecker instanceof VisibilityChecker.Std);
    assertTrue(actualObjectMapperWithJavaTimeModule instanceof JsonMapper);
    PolymorphicTypeValidator polymorphicTypeValidator = actualObjectMapperWithJavaTimeModule
        .getPolymorphicTypeValidator();
    assertTrue(polymorphicTypeValidator instanceof LaissezFaireSubTypeValidator);
    SubtypeResolver subtypeResolver = actualObjectMapperWithJavaTimeModule.getSubtypeResolver();
    assertTrue(subtypeResolver instanceof StdSubtypeResolver);
    DeserializerFactoryConfig factoryConfig = ((BeanDeserializerFactory) factory).getFactoryConfig();
    Iterable<Deserializers> deserializersResult = factoryConfig.deserializers();
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult).next() instanceof SimpleDeserializers);
    SerializerFactory serializerFactory = actualObjectMapperWithJavaTimeModule.getSerializerFactory();
    SerializerFactoryConfig factoryConfig2 = ((BeanSerializerFactory) serializerFactory).getFactoryConfig();
    Iterable<Serializers> serializersResult = factoryConfig2.serializers();
    assertTrue(((ArrayIterator<Serializers>) serializersResult).next() instanceof SimpleSerializers);
    assertTrue(serializerFactory instanceof BeanSerializerFactory);
    SerializerProvider serializerProvider = actualObjectMapperWithJavaTimeModule.getSerializerProvider();
    assertTrue(serializerProvider instanceof DefaultSerializerProvider.Impl);
    SerializerProvider serializerProviderInstance = actualObjectMapperWithJavaTimeModule
        .getSerializerProviderInstance();
    assertTrue(serializerProviderInstance instanceof DefaultSerializerProvider.Impl);
    JsonSerializer<Object> defaultNullKeySerializer = serializerProvider.getDefaultNullKeySerializer();
    assertTrue(defaultNullKeySerializer instanceof FailingSerializer);
    JsonSerializer<Object> defaultNullValueSerializer = serializerProvider.getDefaultNullValueSerializer();
    assertTrue(defaultNullValueSerializer instanceof NullSerializer);
    assertTrue(deserializersResult instanceof ArrayIterator);
    assertTrue(serializersResult instanceof ArrayIterator);
    DateFormat dateFormat = actualObjectMapperWithJavaTimeModule.getDateFormat();
    assertTrue(dateFormat instanceof StdDateFormat);
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult).next() instanceof Jdk8Deserializers);
    assertTrue(((ArrayIterator<Serializers>) serializersResult).next() instanceof Jdk8Serializers);
    JsonFactory factory2 = actualObjectMapperWithJavaTimeModule.getFactory();
    assertEquals(" ", factory2.getRootValueSeparator());
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
    assertEquals("JSON", factory2.getFormatName());
    Base64Variant base64Variant = deserializationConfig.getBase64Variant();
    assertEquals("MIME-NO-LINEFEEDS", base64Variant.getName());
    assertEquals("MIME-NO-LINEFEEDS", base64Variant.toString());
    assertEquals("UTC", timeZone.getID());
    assertEquals("[one of: 'yyyy-MM-dd'T'HH:mm:ss.SSSX', 'EEE, dd MMM yyyy HH:mm:ss zzz' (lenient)]",
        ((StdDateFormat) dateFormat).toPattern());
    Version versionResult = factory2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    Version versionResult2 = actualObjectMapperWithJavaTimeModule.version();
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
    assertNull(factory2.getCharacterEscapes());
    assertNull(factory2.getInputDecorator());
    assertNull(factory2.getOutputDecorator());
    assertNull(deserializationContext.getConfig());
    assertNull(actualObjectMapperWithJavaTimeModule.getInjectableValues());
    assertNull(deserializationContext.getContextualType());
    assertNull(defaultNullKeySerializer.getDelegatee());
    assertNull(defaultNullValueSerializer.getDelegatee());
    assertNull(deserializationConfig.getFullRootName());
    assertNull(serializationConfig.getFullRootName());
    assertNull(actualObjectMapperWithJavaTimeModule.getPropertyNamingStrategy());
    assertNull(deserializationConfig.getPropertyNamingStrategy());
    assertNull(serializationConfig.getPropertyNamingStrategy());
    assertNull(serializerProvider.getConfig());
    assertNull(deserializationConfig.getHandlerInstantiator());
    assertNull(serializationConfig.getHandlerInstantiator());
    assertNull(serializationConfig.getFilterProvider());
    assertNull(serializerProviderInstance.getFilterProvider());
    assertNull(deserializationConfig.getProblemHandlers());
    assertNull(deserializationConfig.getDefaultMergeable());
    assertNull(serializationConfig.getDefaultMergeable());
    assertNull(factory2.getFormatReadFeatureType());
    assertNull(factory2.getFormatWriteFeatureType());
    JsonInclude.Value defaultPropertyInclusion = deserializationConfig.getDefaultPropertyInclusion();
    assertNull(defaultPropertyInclusion.getContentFilter());
    assertNull(defaultPropertyInclusion.getValueFilter());
    assertNull(deserializationContext.getActiveView());
    assertNull(serializerProvider.getActiveView());
    assertNull(serializerProviderInstance.getActiveView());
    assertNull(deserializationConfig.getActiveView());
    assertNull(serializationConfig.getActiveView());
    TypeFactory typeFactory = actualObjectMapperWithJavaTimeModule.getTypeFactory();
    assertNull(typeFactory.getClassLoader());
    assertNull(deserializationConfig.getRootName());
    assertNull(serializationConfig.getRootName());
    assertNull(dateFormat.getNumberFormat());
    assertNull(dateFormat.getCalendar());
    assertNull(dateFormat.getTimeZone());
    assertEquals(0, factory2.getFormatGeneratorFeatures());
    assertEquals(0, factory2.getFormatParserFeatures());
    assertEquals(0, deserializationContext.getDeserializationFeatures());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, factory2.getParserFeatures());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(17, versionResult2.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult2.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(2, versionResult2.getPatchLevel());
    assertEquals(2, actualObjectMapperWithJavaTimeModule.getRegisteredModuleIds().size());
    assertEquals(2079, factory2.getGeneratorFeatures());
    assertEquals(21771068, serializationConfig.getSerializationFeatures());
    assertEquals(31, factory2.getFactoryFeatures());
    assertEquals(473998480, deserializationConfig.getDeserializationFeatures());
    JsonNodeFactory nodeFactory = actualObjectMapperWithJavaTimeModule.getNodeFactory();
    assertEquals(9999, nodeFactory.getMaxElementIndexForInsert());
    assertEquals(JsonInclude.Include.ALWAYS, serializationConfig.getSerializationInclusion());
    assertEquals(JsonInclude.Include.USE_DEFAULTS, defaultPropertyInclusion.getContentInclusion());
    assertEquals(JsonInclude.Include.USE_DEFAULTS, defaultPropertyInclusion.getValueInclusion());
    JsonSetter.Value defaultSetterInfo = deserializationConfig.getDefaultSetterInfo();
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getContentNulls());
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getValueNulls());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult2.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult2.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(versionResult2.isUnknownVersion());
    assertFalse(defaultNullKeySerializer.isUnwrappingSerializer());
    assertFalse(defaultNullValueSerializer.isUnwrappingSerializer());
    assertFalse(factoryConfig.hasAbstractTypeResolvers());
    assertFalse(deserializationConfig.hasExplicitTimeZone());
    assertFalse(serializationConfig.hasExplicitTimeZone());
    assertFalse(((ArrayIterator<Deserializers>) deserializersResult).hasNext());
    assertFalse(((ArrayIterator<Serializers>) serializersResult).hasNext());
    assertFalse(locale.hasExtensions());
    assertTrue(factoryConfig.hasDeserializerModifiers());
    assertTrue(factoryConfig.hasDeserializers());
    assertTrue(factoryConfig.hasKeyDeserializers());
    assertTrue(factoryConfig.hasValueInstantiators());
    assertTrue(deserializationConfig.isAnnotationProcessingEnabled());
    assertTrue(serializationConfig.isAnnotationProcessingEnabled());
    assertTrue(factoryConfig2.hasKeySerializers());
    assertTrue(factoryConfig2.hasSerializerModifiers());
    assertTrue(factoryConfig2.hasSerializers());
    assertTrue(((StdDateFormat) dateFormat).isColonIncludedInTimeZone());
    assertTrue(dateFormat.isLenient());
    Set<Character> extensionKeys = locale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertEquals(Integer.MAX_VALUE, base64Variant.getMaxLineLength());
    assertEquals('=', base64Variant.getPaddingByte());
    assertSame(factory2, actualObjectMapperWithJavaTimeModule.getJsonFactory());
    assertSame(nodeFactory, deserializationConfig.getNodeFactory());
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
    assertSame(extensionKeys, locale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, locale.getUnicodeLocaleKeys());
    assertSame(actualObjectMapperWithJavaTimeModule, factory2.getCodec());
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
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  void testConvertValue() {
    // Arrange
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act
    Object actualConvertValueResult = JacksonUtil.convertValue("From Value", toValueTypeRef);

    // Assert
    verify(toValueTypeRef).getType();
    assertEquals("From Value", actualConvertValueResult);
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  void testConvertValue2() {
    // Arrange
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act
    JacksonUtil.convertValue(42, toValueTypeRef);

    // Assert
    verify(toValueTypeRef).getType();
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  void testConvertValue3() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.<Object>convertValue(null, mock(TypeReference.class)));
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  void testConvertValue4() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.isEnumType()).thenReturn(true);
    when(collectionLikeType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType.getContentType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType.isAbstract()).thenReturn(true);
    when(collectionLikeType.isMapLikeType()).thenReturn(true);
    when(collectionLikeType.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(collectionLikeType.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(collectionLikeType);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(collectionLikeType, atLeast(1)).getKeyType();
    verify(collectionLikeType, atLeast(1)).getRawClass();
    verify(collectionLikeType).isAbstract();
    verify(collectionLikeType).isEnumType();
    verify(collectionLikeType, atLeast(1)).isMapLikeType();
    verify(collectionLikeType, atLeast(1)).getContentType();
    verify(collectionLikeType, atLeast(1)).isContainerType();
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  void testConvertValue5() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  void testConvertValue6() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.isConcrete()).thenReturn(true);
    when(collectionLikeType2.isRecordType()).thenReturn(true);
    when(collectionLikeType2.isArrayType()).thenReturn(true);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<JsonMapper.Builder> forNameResult = JsonMapper.Builder.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2, atLeast(1)).isArrayType();
    verify(collectionLikeType2).isConcrete();
    verify(collectionLikeType2).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).isRecordType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  void testConvertValue7() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.getSuperClass()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(collectionLikeType2.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(collectionLikeType2.isConcrete()).thenReturn(true);
    when(collectionLikeType2.isRecordType()).thenReturn(true);
    when(collectionLikeType2.isArrayType()).thenReturn(false);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<JsonMapper.Builder> forNameResult = JsonMapper.Builder.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).hasRawClass(isA(Class.class));
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2, atLeast(1)).isArrayType();
    verify(collectionLikeType2).isConcrete();
    verify(collectionLikeType2, atLeast(1)).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).isRecordType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
    verify(collectionLikeType2).getBindings();
    verify(collectionLikeType2).getSuperClass();
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  void testConvertValue8() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    Class<Object> erasedType = Object.class;
    when(collectionLikeType2.getSuperClass())
        .thenReturn(new ResolvedRecursiveType(erasedType, TypeBindings.emptyBindings()));
    when(collectionLikeType2.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(collectionLikeType2.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(collectionLikeType2.isConcrete()).thenReturn(true);
    when(collectionLikeType2.isRecordType()).thenReturn(true);
    when(collectionLikeType2.isArrayType()).thenReturn(false);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<JsonMapper.Builder> forNameResult = JsonMapper.Builder.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).hasRawClass(isA(Class.class));
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2, atLeast(1)).isArrayType();
    verify(collectionLikeType2).isConcrete();
    verify(collectionLikeType2, atLeast(1)).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).isRecordType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
    verify(collectionLikeType2).getBindings();
    verify(collectionLikeType2).getSuperClass();
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  void testConvertValue9() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<String> forNameResult = String.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, TypeReference)}
   */
  @Test
  void testConvertValue10() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.getSuperClass()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(collectionLikeType2.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(collectionLikeType2.isConcrete()).thenReturn(true);
    when(collectionLikeType2.isRecordType()).thenReturn(true);
    when(collectionLikeType2.isArrayType()).thenReturn(false);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<JacksonUtil> forNameResult = JacksonUtil.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> toValueTypeRef = mock(TypeReference.class);
    when(toValueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueTypeRef));
    verify(toValueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).hasRawClass(isA(Class.class));
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2, atLeast(1)).isArrayType();
    verify(collectionLikeType2).isConcrete();
    verify(collectionLikeType2, atLeast(1)).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).isRecordType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
    verify(collectionLikeType2, atLeast(1)).getBindings();
    verify(collectionLikeType2).getSuperClass();
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  void testConvertValue11() {
    // Arrange
    Class<Object> toValueType = Object.class;

    // Act and Assert
    assertEquals("From Value", JacksonUtil.convertValue("From Value", toValueType));
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  void testConvertValue12() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.convertValue(null, (Class<Object>) null));
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  void testConvertValue13() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", (Class<Object>) null));
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  void testConvertValue14() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Class<Object> toValueType = Object.class;

    // Act and Assert
    assertEquals("java.lang.Object", JacksonUtil.convertValue(forNameResult, toValueType));
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  void testConvertValue15() {
    // Arrange
    Class<JsonMapper.Builder> toValueType = JsonMapper.Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueType));
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  void testConvertValue16() {
    // Arrange
    Class<JsonMapper.Builder> toValueType = JsonMapper.Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue(42, toValueType));
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  void testConvertValue17() {
    // Arrange
    Class<String> toValueType = String.class;

    // Act and Assert
    assertEquals("42", JacksonUtil.convertValue(42, toValueType));
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  void testConvertValue18() {
    // Arrange
    Class<JacksonUtil> toValueType = JacksonUtil.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("From Value", toValueType));
  }

  /**
   * Method under test: {@link JacksonUtil#convertValue(Object, Class)}
   */
  @Test
  void testConvertValue19() {
    // Arrange
    Class<JsonMapper.Builder> toValueType = JsonMapper.Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.convertValue("", toValueType));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  void testFromString() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  void testFromString2() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.<Object>fromString(null, mock(TypeReference.class)));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  void testFromString3() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  void testFromString4() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act
    JacksonUtil.fromString("42", valueTypeRef);

    // Assert
    verify(valueTypeRef).getType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  void testFromString5() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("", valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  void testFromString6() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  void testFromString7() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.isEnumType()).thenReturn(true);
    when(collectionLikeType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType.getContentType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType.isAbstract()).thenReturn(true);
    when(collectionLikeType.isMapLikeType()).thenReturn(true);
    when(collectionLikeType.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(collectionLikeType.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(collectionLikeType);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(collectionLikeType, atLeast(1)).getKeyType();
    verify(collectionLikeType, atLeast(1)).getRawClass();
    verify(collectionLikeType).isAbstract();
    verify(collectionLikeType).isEnumType();
    verify(collectionLikeType, atLeast(1)).isMapLikeType();
    verify(collectionLikeType, atLeast(1)).getContentType();
    verify(collectionLikeType, atLeast(1)).isContainerType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  void testFromString8() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(collectionLikeType.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(collectionLikeType);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(collectionLikeType).getRawClass();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  void testFromString9() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  void testFromString10() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.isConcrete()).thenReturn(true);
    when(collectionLikeType2.isRecordType()).thenReturn(true);
    when(collectionLikeType2.isArrayType()).thenReturn(true);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<JsonMapper.Builder> forNameResult = JsonMapper.Builder.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2, atLeast(1)).isArrayType();
    verify(collectionLikeType2).isConcrete();
    verify(collectionLikeType2).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).isRecordType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  void testFromString11() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.getSuperClass()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(collectionLikeType2.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(collectionLikeType2.isConcrete()).thenReturn(true);
    when(collectionLikeType2.isRecordType()).thenReturn(true);
    when(collectionLikeType2.isArrayType()).thenReturn(false);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<JsonMapper.Builder> forNameResult = JsonMapper.Builder.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).hasRawClass(isA(Class.class));
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2, atLeast(1)).isArrayType();
    verify(collectionLikeType2).isConcrete();
    verify(collectionLikeType2, atLeast(1)).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).isRecordType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
    verify(collectionLikeType2).getBindings();
    verify(collectionLikeType2).getSuperClass();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  void testFromString12() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    Class<Object> erasedType = Object.class;
    when(collectionLikeType2.getSuperClass())
        .thenReturn(new ResolvedRecursiveType(erasedType, TypeBindings.emptyBindings()));
    when(collectionLikeType2.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(collectionLikeType2.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(collectionLikeType2.isConcrete()).thenReturn(true);
    when(collectionLikeType2.isRecordType()).thenReturn(true);
    when(collectionLikeType2.isArrayType()).thenReturn(false);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<JsonMapper.Builder> forNameResult = JsonMapper.Builder.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).hasRawClass(isA(Class.class));
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2, atLeast(1)).isArrayType();
    verify(collectionLikeType2).isConcrete();
    verify(collectionLikeType2, atLeast(1)).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).isRecordType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
    verify(collectionLikeType2).getBindings();
    verify(collectionLikeType2).getSuperClass();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, TypeReference)}
   */
  @Test
  void testFromString13() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType collectionLikeType2 = mock(CollectionLikeType.class);
    when(collectionLikeType2.getSuperClass()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(collectionLikeType2.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(collectionLikeType2.isConcrete()).thenReturn(true);
    when(collectionLikeType2.isRecordType()).thenReturn(true);
    when(collectionLikeType2.isArrayType()).thenReturn(false);
    when(collectionLikeType2.isEnumType()).thenReturn(true);
    when(collectionLikeType2.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(collectionLikeType2.getContentType()).thenReturn(collectionLikeType);
    when(collectionLikeType2.isAbstract()).thenReturn(true);
    when(collectionLikeType2.isMapLikeType()).thenReturn(true);
    when(collectionLikeType2.isContainerType()).thenReturn(true);
    Class<JacksonUtil> forNameResult = JacksonUtil.class;
    Mockito.<Class<?>>when(collectionLikeType2.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(collectionLikeType2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", valueTypeRef));
    verify(valueTypeRef).getType();
    verify(collectionLikeType2, atLeast(1)).getKeyType();
    verify(collectionLikeType2, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(collectionLikeType2).hasRawClass(isA(Class.class));
    verify(collectionLikeType2).isAbstract();
    verify(collectionLikeType2, atLeast(1)).isArrayType();
    verify(collectionLikeType2).isConcrete();
    verify(collectionLikeType2, atLeast(1)).isEnumType();
    verify(collectionLikeType2, atLeast(1)).isMapLikeType();
    verify(collectionLikeType2, atLeast(1)).isRecordType();
    verify(collectionLikeType2, atLeast(1)).getContentType();
    verify(collectionLikeType2, atLeast(1)).isContainerType();
    verify(collectionLikeType2, atLeast(1)).getBindings();
    verify(collectionLikeType2).getSuperClass();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  void testFromString14() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", new PlaceholderForType(1)));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  void testFromString15() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.fromString(null, new PlaceholderForType(1)));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  void testFromString16() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", new PlaceholderForType(1)));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  void testFromString17() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("", new PlaceholderForType(1)));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  void testFromString18() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.fromString(null, mock(CollectionLikeType.class)));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  void testFromString19() {
    // Arrange
    CollectionLikeType javaType = mock(CollectionLikeType.class);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(new PlaceholderForType(1));
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(javaType).isAbstract();
    verify(javaType).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType, atLeast(1)).isContainerType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  void testFromString20() {
    // Arrange
    CollectionLikeType javaType = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("", javaType));
    verify(javaType).getRawClass();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  void testFromString21() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType javaType = mock(CollectionLikeType.class);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(collectionLikeType);
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(javaType).isAbstract();
    verify(javaType).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType, atLeast(1)).isContainerType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  void testFromString22() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType javaType = mock(CollectionLikeType.class);
    when(javaType.isConcrete()).thenReturn(true);
    when(javaType.isRecordType()).thenReturn(true);
    when(javaType.isArrayType()).thenReturn(true);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(collectionLikeType);
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<JsonMapper.Builder> forNameResult = JsonMapper.Builder.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(javaType).isAbstract();
    verify(javaType, atLeast(1)).isArrayType();
    verify(javaType).isConcrete();
    verify(javaType).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).isRecordType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType, atLeast(1)).isContainerType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  void testFromString23() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType javaType = mock(CollectionLikeType.class);
    when(javaType.getSuperClass()).thenReturn(new PlaceholderForType(1));
    when(javaType.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(javaType.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(javaType.isConcrete()).thenReturn(true);
    when(javaType.isRecordType()).thenReturn(true);
    when(javaType.isArrayType()).thenReturn(false);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(collectionLikeType);
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<JsonMapper.Builder> forNameResult = JsonMapper.Builder.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(javaType).hasRawClass(isA(Class.class));
    verify(javaType).isAbstract();
    verify(javaType, atLeast(1)).isArrayType();
    verify(javaType).isConcrete();
    verify(javaType, atLeast(1)).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).isRecordType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType, atLeast(1)).isContainerType();
    verify(javaType).getBindings();
    verify(javaType).getSuperClass();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  void testFromString24() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType javaType = mock(CollectionLikeType.class);
    Class<Object> erasedType = Object.class;
    when(javaType.getSuperClass()).thenReturn(new ResolvedRecursiveType(erasedType, TypeBindings.emptyBindings()));
    when(javaType.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(javaType.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(javaType.isConcrete()).thenReturn(true);
    when(javaType.isRecordType()).thenReturn(true);
    when(javaType.isArrayType()).thenReturn(false);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(collectionLikeType);
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<JsonMapper.Builder> forNameResult = JsonMapper.Builder.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(javaType).hasRawClass(isA(Class.class));
    verify(javaType).isAbstract();
    verify(javaType, atLeast(1)).isArrayType();
    verify(javaType).isConcrete();
    verify(javaType, atLeast(1)).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).isRecordType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType, atLeast(1)).isContainerType();
    verify(javaType).getBindings();
    verify(javaType).getSuperClass();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, JavaType)}
   */
  @Test
  void testFromString25() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getValueHandler()).thenReturn("Value Handler");
    CollectionLikeType javaType = mock(CollectionLikeType.class);
    when(javaType.getSuperClass()).thenReturn(new PlaceholderForType(1));
    when(javaType.getBindings()).thenReturn(TypeBindings.emptyBindings());
    when(javaType.hasRawClass(Mockito.<Class<Object>>any())).thenReturn(true);
    when(javaType.isConcrete()).thenReturn(true);
    when(javaType.isRecordType()).thenReturn(true);
    when(javaType.isArrayType()).thenReturn(false);
    when(javaType.isEnumType()).thenReturn(true);
    when(javaType.getKeyType()).thenReturn(new PlaceholderForType(1));
    when(javaType.getContentType()).thenReturn(collectionLikeType);
    when(javaType.isAbstract()).thenReturn(true);
    when(javaType.isMapLikeType()).thenReturn(true);
    when(javaType.isContainerType()).thenReturn(true);
    Class<JacksonUtil> forNameResult = JacksonUtil.class;
    Mockito.<Class<?>>when(javaType.getRawClass()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", javaType));
    verify(javaType, atLeast(1)).getKeyType();
    verify(javaType, atLeast(1)).getRawClass();
    verify(collectionLikeType, atLeast(1)).getValueHandler();
    verify(javaType).hasRawClass(isA(Class.class));
    verify(javaType).isAbstract();
    verify(javaType, atLeast(1)).isArrayType();
    verify(javaType).isConcrete();
    verify(javaType, atLeast(1)).isEnumType();
    verify(javaType, atLeast(1)).isMapLikeType();
    verify(javaType, atLeast(1)).isRecordType();
    verify(javaType, atLeast(1)).getContentType();
    verify(javaType, atLeast(1)).isContainerType();
    verify(javaType, atLeast(1)).getBindings();
    verify(javaType).getSuperClass();
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  void testFromString26() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  void testFromString27() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.fromString(null, (Class<Object>) null));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  void testFromString28() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  void testFromString29() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("", clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  void testFromString30() {
    // Arrange
    Class<JsonMapper.Builder> clazz = JsonMapper.Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  void testFromString31() {
    // Arrange
    Class<String> clazz = String.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  void testFromString32() {
    // Arrange
    Class<JsonMapper.Builder> clazz = JsonMapper.Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  void testFromString33() {
    // Arrange
    Class<JsonMapper.Builder> clazz = JsonMapper.Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("42", clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  void testFromString34() {
    // Arrange
    Class<String> clazz = String.class;

    // Act and Assert
    assertEquals("42", JacksonUtil.fromString("42", clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class)}
   */
  @Test
  void testFromString35() {
    // Arrange
    Class<JacksonUtil> clazz = JacksonUtil.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("42", clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  void testFromString36() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", clazz, true));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  void testFromString37() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.fromString(null, null, true));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  void testFromString38() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", clazz, true));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  void testFromString39() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("", clazz, true));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  void testFromString40() {
    // Arrange
    Class<JsonMapper.Builder> clazz = JsonMapper.Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("String", clazz, true));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  void testFromString41() {
    // Arrange
    Class<JsonMapper.Builder> clazz = JsonMapper.Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", clazz, true));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  void testFromString42() {
    // Arrange
    Class<JsonMapper.Builder> clazz = JsonMapper.Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("42", clazz, true));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  void testFromString43() {
    // Arrange
    Class<String> clazz = String.class;

    // Act and Assert
    assertEquals("42", JacksonUtil.fromString("42", clazz, true));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  void testFromString44() {
    // Arrange
    Class<JacksonUtil> clazz = JacksonUtil.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("\"", clazz, true));
  }

  /**
   * Method under test: {@link JacksonUtil#fromString(String, Class, boolean)}
   */
  @Test
  void testFromString45() {
    // Arrange
    Class<JacksonUtil> clazz = JacksonUtil.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromString("42", clazz, true));
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  void testFromBytes() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes("AXAXAXAX".getBytes("UTF-8")));
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 0, 0, 'X', 'A', 'X', 'A', 'X'}));
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 0, 'A', 0, 'A', 'X', 'A', 'X'}));
    assertNull(JacksonUtil.<Object>fromBytes(null, mock(TypeReference.class)));
    assertNull(JacksonUtil.fromBytes(null, (Class<Object>) null));
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[])}
   */
  @Test
  void testFromBytes2() throws IOException {
    // Arrange and Act
    JsonNode actualFromBytesResult = JacksonUtil.fromBytes(new byte[]{});

    // Assert
    assertTrue(actualFromBytesResult instanceof MissingNode);
    JsonParser traverseResult = actualFromBytesResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("", actualFromBytesResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualFromBytesResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.MISSING, actualFromBytesResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualFromBytesResult.isArray());
    assertFalse(actualFromBytesResult.isBigDecimal());
    assertFalse(actualFromBytesResult.isBigInteger());
    assertFalse(actualFromBytesResult.isBinary());
    assertFalse(actualFromBytesResult.isBoolean());
    assertFalse(actualFromBytesResult.isContainerNode());
    assertFalse(actualFromBytesResult.isDouble());
    assertFalse(actualFromBytesResult.isFloat());
    assertFalse(actualFromBytesResult.isFloatingPointNumber());
    assertFalse(actualFromBytesResult.isInt());
    assertFalse(actualFromBytesResult.isIntegralNumber());
    assertFalse(actualFromBytesResult.isLong());
    assertFalse(actualFromBytesResult.isNull());
    assertFalse(actualFromBytesResult.isNumber());
    assertFalse(actualFromBytesResult.isObject());
    assertFalse(actualFromBytesResult.isPojo());
    assertFalse(actualFromBytesResult.isShort());
    assertFalse(actualFromBytesResult.isTextual());
    assertFalse(actualFromBytesResult.isValueNode());
    assertFalse(actualFromBytesResult.iterator().hasNext());
    assertTrue(actualFromBytesResult.isEmpty());
    assertTrue(actualFromBytesResult.isMissingNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  void testFromBytes3() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(bytes, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  void testFromBytes4() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  void testFromBytes5() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  void testFromBytes6() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  void testFromBytes7() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(new byte[]{}, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  void testFromBytes8() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(bytes, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  void testFromBytes9() {
    // Arrange
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'}, valueTypeRef));
    verify(valueTypeRef).getType();
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[], TypeReference)}
   */
  @Test
  void testFromBytes10() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(collectionLikeType.getRawClass()).thenReturn(forNameResult);
    TypeReference<Object> valueTypeRef = mock(TypeReference.class);
    when(valueTypeRef.getType()).thenReturn(collectionLikeType);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(new byte[]{}, valueTypeRef));
    verify(valueTypeRef).getType();
    verify(collectionLikeType).getRawClass();
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  void testFromBytes11() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(bytes, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  void testFromBytes12() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  void testFromBytes13() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  void testFromBytes14() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  void testFromBytes15() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(new byte[]{}, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  void testFromBytes16() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    Class<JsonMapper.Builder> clazz = JsonMapper.Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(bytes, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  void testFromBytes17() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    Class<String> clazz = String.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromBytes(bytes, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  void testFromBytes18() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromBytes(byte[], Class)}
   */
  @Test
  void testFromBytes19() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.fromBytes(new byte[]{0, 0, 'A', 0, 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#toString(Object)}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("\"Value\"", JacksonUtil.toString("Value"));
    assertNull(JacksonUtil.toString(null));
    assertEquals("\"\\\"\"", JacksonUtil.toString("\""));
  }

  /**
   * Method under test: {@link JacksonUtil#writeValueAsString(Object)}
   */
  @Test
  void testWriteValueAsString() {
    // Arrange, Act and Assert
    assertEquals("null", JacksonUtil.writeValueAsString(null));
    assertEquals("42", JacksonUtil.writeValueAsString(42));
    assertEquals("\"\\\"\"", JacksonUtil.writeValueAsString("\""));
  }

  /**
   * Method under test: {@link JacksonUtil#toPrettyString(Object)}
   */
  @Test
  void testToPrettyString() {
    // Arrange, Act and Assert
    assertEquals("null", JacksonUtil.toPrettyString(null));
  }

  /**
   * Method under test: {@link JacksonUtil#toPlainText(String)}
   */
  @Test
  void testToPlainText() {
    // Arrange, Act and Assert
    assertEquals("Data", JacksonUtil.toPlainText("Data"));
    assertNull(JacksonUtil.toPlainText(null));
    assertEquals("\"", JacksonUtil.toPlainText("\""));
    assertEquals("", JacksonUtil.toPlainText("\"\""));
    assertEquals("\"Data", JacksonUtil.toPlainText("\"Data"));
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue() {
    // Arrange
    MissingNode node = MissingNode.getInstance();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue2() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.treeToValue(null, null));
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue3() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    Class<Object> clazz = Object.class;

    // Act
    Object actualTreeToValueResult = JacksonUtil.treeToValue(node, clazz);

    // Assert
    assertTrue(actualTreeToValueResult instanceof List);
    assertTrue(((List<Object>) actualTreeToValueResult).isEmpty());
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue4() {
    // Arrange
    BigIntegerNode node = new BigIntegerNode(BigInteger.valueOf(1L));
    Class<Object> clazz = Object.class;

    // Act
    Object actualTreeToValueResult = JacksonUtil.treeToValue(node, clazz);

    // Assert
    assertTrue(actualTreeToValueResult instanceof BigInteger);
    assertEquals("1", actualTreeToValueResult.toString());
    assertEquals(0, ((BigInteger) actualTreeToValueResult).getLowestSetBit());
    assertEquals(1, ((BigInteger) actualTreeToValueResult).signum());
    assertArrayEquals(new byte[]{1}, ((BigInteger) actualTreeToValueResult).toByteArray());
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue5() {
    // Arrange
    NullNode node = NullNode.getInstance();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue6() {
    // Arrange
    DoubleNode node = DoubleNode.valueOf(10.0d);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(10.0d, ((Double) JacksonUtil.treeToValue(node, clazz)).doubleValue());
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue7() {
    // Arrange
    FloatNode node = FloatNode.valueOf(10.0f);
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(10.0f, ((Float) JacksonUtil.treeToValue(node, clazz)).floatValue());
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue8() {
    // Arrange
    MissingNode node = MissingNode.getInstance();
    Class<JsonMapper.Builder> clazz = JsonMapper.Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue9() {
    // Arrange
    MissingNode node = MissingNode.getInstance();
    Class<String> clazz = String.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue10() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue11() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.addArray();
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue12() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.addObject();
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue13() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.addPOJO("Pojo");
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue14() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.addNull();
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue15() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.add(-0.5f);
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue16() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.add("");
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue17() throws UnsupportedEncodingException {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.add("AXAXAXAX".getBytes("UTF-8"));
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue18() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.addPOJO(2);
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#treeToValue(JsonNode, Class)}
   */
  @Test
  void testTreeToValue19() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.addPOJO(42);
    node.add(MissingNode.getInstance());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.treeToValue(node, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#toJsonNode(File)}
   */
  @Test
  void testToJsonNode() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.toJsonNode(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    assertNull(JacksonUtil.toJsonNode((File) null));
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.toJsonNode(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    assertNull(JacksonUtil.toJsonNode((InputStream) null));
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.toJsonNode(new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil
        .toJsonNode(new ByteArrayInputStream(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.toJsonNode(new ByteArrayInputStream(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'})));
    assertNull(JacksonUtil.toJsonNode((String) null));
    assertNull(JacksonUtil.toJsonNode(""));
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode("Value"));
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode("\""));
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode("42Value"));
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.toJsonNode("Value", JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER));
    assertNull(JacksonUtil.toJsonNode(null, JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER));
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.toJsonNode("\"", JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER));
    assertNull(JacksonUtil.toJsonNode("", JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER));
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.toJsonNode(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  void testToJsonNode2() throws IOException {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertTrue(actualToJsonNodeResult instanceof MissingNode);
    JsonParser traverseResult = actualToJsonNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("", actualToJsonNodeResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.MISSING, actualToJsonNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isInt());
    assertFalse(actualToJsonNodeResult.isIntegralNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isNumber());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(actualToJsonNodeResult.isValueNode());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isMissingNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  void testToJsonNode3() throws IOException {
    // Arrange
    DataInputStream value = mock(DataInputStream.class);
    when(value.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(value).close();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode(value));
    verify(value, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(value).close();
  }

  /**
   * Method under test: {@link JacksonUtil#toJsonNode(InputStream)}
   */
  @Test
  void testToJsonNode4() throws IOException {
    // Arrange
    DataInputStream value = mock(DataInputStream.class);
    when(value.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JacksonUtil.toJsonNode(value));
    verify(value).read(isA(byte[].class), eq(0), eq(8000));
  }

  /**
   * Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  void testToJsonNode5() throws IOException {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42");

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    JsonParser traverseResult = actualToJsonNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  void testToJsonNode6() throws IOException {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("\"\"");

    // Assert
    assertTrue(actualToJsonNodeResult instanceof TextNode);
    JsonParser traverseResult = actualToJsonNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"\"", actualToJsonNodeResult.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.STRING, actualToJsonNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isInt());
    assertFalse(actualToJsonNodeResult.isIntegralNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isNumber());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isTextual());
    assertTrue(actualToJsonNodeResult.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#toJsonNode(String)}
   */
  @Test
  void testToJsonNode7() throws IOException {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("\"42\"");

    // Assert
    assertTrue(actualToJsonNodeResult instanceof TextNode);
    JsonParser traverseResult = actualToJsonNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"42\"", actualToJsonNodeResult.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.STRING, actualToJsonNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isInt());
    assertFalse(actualToJsonNodeResult.isIntegralNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isNumber());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isTextual());
    assertTrue(actualToJsonNodeResult.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  void testToJsonNode8() throws IOException {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    JsonParser traverseResult = actualToJsonNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  void testToJsonNode9() throws IOException {
    // Arrange and Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", new ObjectMapper());

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    JsonParser traverseResult = actualToJsonNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  void testToJsonNode10() throws IOException {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializerFactory(mock(SerializerFactory.class));

    // Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", mapper);

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    JsonParser traverseResult = actualToJsonNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  void testToJsonNode11() throws IOException {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    mapper.setConfig(new DeserializationConfig(base, str, mixins, rootNames, configOverrides, new CoercionConfigs(),
        mock(DatatypeFeatures.class)));

    // Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", mapper);

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    JsonParser traverseResult = actualToJsonNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  void testToJsonNode12() throws IOException {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    mapper.setConfig(new DeserializationConfig(base, str, mixins, rootNames, configOverrides, new CoercionConfigs(),
        mock(DatatypeFeatures.class)));

    // Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", mapper);

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    JsonParser traverseResult = actualToJsonNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  void testToJsonNode13() throws IOException {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.NON_CONCRETE_AND_ARRAYS);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    mapper.setConfig(new DeserializationConfig(base, str, mixins, rootNames, configOverrides, new CoercionConfigs(),
        mock(DatatypeFeatures.class)));

    // Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", mapper);

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    JsonParser traverseResult = actualToJsonNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  void testToJsonNode14() throws IOException {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.NON_FINAL);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    mapper.setConfig(new DeserializationConfig(base, str, mixins, rootNames, configOverrides, new CoercionConfigs(),
        mock(DatatypeFeatures.class)));

    // Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", mapper);

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    JsonParser traverseResult = actualToJsonNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  void testToJsonNode15() {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    mapper.setConfig(new DeserializationConfig(base, str, mixins, rootNames, configOverrides, new CoercionConfigs(),
        mock(DatatypeFeatures.class)));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.toJsonNode("42", mapper));
  }

  /**
   * Method under test: {@link JacksonUtil#toJsonNode(String, ObjectMapper)}
   */
  @Test
  void testToJsonNode16() throws IOException {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.NON_FINAL_AND_ENUMS);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    mapper.setConfig(new DeserializationConfig(base, str, mixins, rootNames, configOverrides, new CoercionConfigs(),
        mock(DatatypeFeatures.class)));

    // Act
    JsonNode actualToJsonNodeResult = JacksonUtil.toJsonNode("42", mapper);

    // Assert
    assertTrue(actualToJsonNodeResult instanceof IntNode);
    JsonParser traverseResult = actualToJsonNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", actualToJsonNodeResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualToJsonNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, actualToJsonNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualToJsonNodeResult.isArray());
    assertFalse(actualToJsonNodeResult.isBigDecimal());
    assertFalse(actualToJsonNodeResult.isBigInteger());
    assertFalse(actualToJsonNodeResult.isBinary());
    assertFalse(actualToJsonNodeResult.isBoolean());
    assertFalse(actualToJsonNodeResult.isContainerNode());
    assertFalse(actualToJsonNodeResult.isDouble());
    assertFalse(actualToJsonNodeResult.isFloat());
    assertFalse(actualToJsonNodeResult.isFloatingPointNumber());
    assertFalse(actualToJsonNodeResult.isLong());
    assertFalse(actualToJsonNodeResult.isMissingNode());
    assertFalse(actualToJsonNodeResult.isNull());
    assertFalse(actualToJsonNodeResult.isObject());
    assertFalse(actualToJsonNodeResult.isPojo());
    assertFalse(actualToJsonNodeResult.isShort());
    assertFalse(actualToJsonNodeResult.isTextual());
    assertFalse(((IntNode) actualToJsonNodeResult).isNaN());
    assertFalse(actualToJsonNodeResult.iterator().hasNext());
    assertTrue(actualToJsonNodeResult.isEmpty());
    assertTrue(actualToJsonNodeResult.isInt());
    assertTrue(actualToJsonNodeResult.isIntegralNumber());
    assertTrue(actualToJsonNodeResult.isNumber());
    assertTrue(actualToJsonNodeResult.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#readValue(File, TypeReference)}
   */
  @Test
  void testReadValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.<Object>readValue(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
            mock(TypeReference.class)));
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue("File", null));
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue("", null));
  }

  /**
   * Method under test: {@link JacksonUtil#readValue(File, Class)}
   */
  @Test
  void testReadValue2() {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.readValue(file, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#newObjectNode()}
   */
  @Test
  void testNewObjectNode() throws IOException {
    // Arrange and Act
    ObjectNode actualNewObjectNodeResult = JacksonUtil.newObjectNode();

    // Assert
    JsonParser traverseResult = actualNewObjectNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", actualNewObjectNodeResult.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualNewObjectNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, actualNewObjectNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualNewObjectNodeResult.isArray());
    assertFalse(actualNewObjectNodeResult.isBigDecimal());
    assertFalse(actualNewObjectNodeResult.isBigInteger());
    assertFalse(actualNewObjectNodeResult.isBinary());
    assertFalse(actualNewObjectNodeResult.isBoolean());
    assertFalse(actualNewObjectNodeResult.isDouble());
    assertFalse(actualNewObjectNodeResult.isFloat());
    assertFalse(actualNewObjectNodeResult.isFloatingPointNumber());
    assertFalse(actualNewObjectNodeResult.isInt());
    assertFalse(actualNewObjectNodeResult.isIntegralNumber());
    assertFalse(actualNewObjectNodeResult.isLong());
    assertFalse(actualNewObjectNodeResult.isMissingNode());
    assertFalse(actualNewObjectNodeResult.isNull());
    assertFalse(actualNewObjectNodeResult.isNumber());
    assertFalse(actualNewObjectNodeResult.isPojo());
    assertFalse(actualNewObjectNodeResult.isShort());
    assertFalse(actualNewObjectNodeResult.isTextual());
    assertFalse(actualNewObjectNodeResult.isValueNode());
    assertFalse(actualNewObjectNodeResult.iterator().hasNext());
    assertTrue(actualNewObjectNodeResult.isContainerNode());
    assertTrue(actualNewObjectNodeResult.isEmpty());
    assertTrue(actualNewObjectNodeResult.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#newObjectNode(ObjectMapper)}
   */
  @Test
  void testNewObjectNode2() throws IOException {
    // Arrange and Act
    ObjectNode actualNewObjectNodeResult = JacksonUtil.newObjectNode(JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    JsonParser traverseResult = actualNewObjectNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", actualNewObjectNodeResult.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualNewObjectNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, actualNewObjectNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualNewObjectNodeResult.isArray());
    assertFalse(actualNewObjectNodeResult.isBigDecimal());
    assertFalse(actualNewObjectNodeResult.isBigInteger());
    assertFalse(actualNewObjectNodeResult.isBinary());
    assertFalse(actualNewObjectNodeResult.isBoolean());
    assertFalse(actualNewObjectNodeResult.isDouble());
    assertFalse(actualNewObjectNodeResult.isFloat());
    assertFalse(actualNewObjectNodeResult.isFloatingPointNumber());
    assertFalse(actualNewObjectNodeResult.isInt());
    assertFalse(actualNewObjectNodeResult.isIntegralNumber());
    assertFalse(actualNewObjectNodeResult.isLong());
    assertFalse(actualNewObjectNodeResult.isMissingNode());
    assertFalse(actualNewObjectNodeResult.isNull());
    assertFalse(actualNewObjectNodeResult.isNumber());
    assertFalse(actualNewObjectNodeResult.isPojo());
    assertFalse(actualNewObjectNodeResult.isShort());
    assertFalse(actualNewObjectNodeResult.isTextual());
    assertFalse(actualNewObjectNodeResult.isValueNode());
    assertFalse(actualNewObjectNodeResult.iterator().hasNext());
    assertTrue(actualNewObjectNodeResult.isContainerNode());
    assertTrue(actualNewObjectNodeResult.isEmpty());
    assertTrue(actualNewObjectNodeResult.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#newObjectNode(ObjectMapper)}
   */
  @Test
  void testNewObjectNode3() throws IOException {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializerFactory(mock(SerializerFactory.class));

    // Act
    ObjectNode actualNewObjectNodeResult = JacksonUtil.newObjectNode(mapper);

    // Assert
    JsonParser traverseResult = actualNewObjectNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", actualNewObjectNodeResult.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualNewObjectNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, actualNewObjectNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualNewObjectNodeResult.isArray());
    assertFalse(actualNewObjectNodeResult.isBigDecimal());
    assertFalse(actualNewObjectNodeResult.isBigInteger());
    assertFalse(actualNewObjectNodeResult.isBinary());
    assertFalse(actualNewObjectNodeResult.isBoolean());
    assertFalse(actualNewObjectNodeResult.isDouble());
    assertFalse(actualNewObjectNodeResult.isFloat());
    assertFalse(actualNewObjectNodeResult.isFloatingPointNumber());
    assertFalse(actualNewObjectNodeResult.isInt());
    assertFalse(actualNewObjectNodeResult.isIntegralNumber());
    assertFalse(actualNewObjectNodeResult.isLong());
    assertFalse(actualNewObjectNodeResult.isMissingNode());
    assertFalse(actualNewObjectNodeResult.isNull());
    assertFalse(actualNewObjectNodeResult.isNumber());
    assertFalse(actualNewObjectNodeResult.isPojo());
    assertFalse(actualNewObjectNodeResult.isShort());
    assertFalse(actualNewObjectNodeResult.isTextual());
    assertFalse(actualNewObjectNodeResult.isValueNode());
    assertFalse(actualNewObjectNodeResult.iterator().hasNext());
    assertTrue(actualNewObjectNodeResult.isContainerNode());
    assertTrue(actualNewObjectNodeResult.isEmpty());
    assertTrue(actualNewObjectNodeResult.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#newArrayNode()}
   */
  @Test
  void testNewArrayNode() throws IOException {
    // Arrange and Act
    ArrayNode actualNewArrayNodeResult = JacksonUtil.newArrayNode();

    // Assert
    JsonParser traverseResult = actualNewArrayNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("[ ]", actualNewArrayNodeResult.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualNewArrayNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.ARRAY, actualNewArrayNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualNewArrayNodeResult.isBigDecimal());
    assertFalse(actualNewArrayNodeResult.isBigInteger());
    assertFalse(actualNewArrayNodeResult.isBinary());
    assertFalse(actualNewArrayNodeResult.isBoolean());
    assertFalse(actualNewArrayNodeResult.isDouble());
    assertFalse(actualNewArrayNodeResult.isFloat());
    assertFalse(actualNewArrayNodeResult.isFloatingPointNumber());
    assertFalse(actualNewArrayNodeResult.isInt());
    assertFalse(actualNewArrayNodeResult.isIntegralNumber());
    assertFalse(actualNewArrayNodeResult.isLong());
    assertFalse(actualNewArrayNodeResult.isMissingNode());
    assertFalse(actualNewArrayNodeResult.isNull());
    assertFalse(actualNewArrayNodeResult.isNumber());
    assertFalse(actualNewArrayNodeResult.isObject());
    assertFalse(actualNewArrayNodeResult.isPojo());
    assertFalse(actualNewArrayNodeResult.isShort());
    assertFalse(actualNewArrayNodeResult.isTextual());
    assertFalse(actualNewArrayNodeResult.isValueNode());
    assertFalse(actualNewArrayNodeResult.iterator().hasNext());
    assertFalse(actualNewArrayNodeResult.elements().hasNext());
    assertTrue(actualNewArrayNodeResult.isContainerNode());
    assertTrue(actualNewArrayNodeResult.isArray());
    assertTrue(actualNewArrayNodeResult.isEmpty());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#newArrayNode(ObjectMapper)}
   */
  @Test
  void testNewArrayNode2() throws IOException {
    // Arrange and Act
    ArrayNode actualNewArrayNodeResult = JacksonUtil.newArrayNode(JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    JsonParser traverseResult = actualNewArrayNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("[ ]", actualNewArrayNodeResult.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualNewArrayNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.ARRAY, actualNewArrayNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualNewArrayNodeResult.isBigDecimal());
    assertFalse(actualNewArrayNodeResult.isBigInteger());
    assertFalse(actualNewArrayNodeResult.isBinary());
    assertFalse(actualNewArrayNodeResult.isBoolean());
    assertFalse(actualNewArrayNodeResult.isDouble());
    assertFalse(actualNewArrayNodeResult.isFloat());
    assertFalse(actualNewArrayNodeResult.isFloatingPointNumber());
    assertFalse(actualNewArrayNodeResult.isInt());
    assertFalse(actualNewArrayNodeResult.isIntegralNumber());
    assertFalse(actualNewArrayNodeResult.isLong());
    assertFalse(actualNewArrayNodeResult.isMissingNode());
    assertFalse(actualNewArrayNodeResult.isNull());
    assertFalse(actualNewArrayNodeResult.isNumber());
    assertFalse(actualNewArrayNodeResult.isObject());
    assertFalse(actualNewArrayNodeResult.isPojo());
    assertFalse(actualNewArrayNodeResult.isShort());
    assertFalse(actualNewArrayNodeResult.isTextual());
    assertFalse(actualNewArrayNodeResult.isValueNode());
    assertFalse(actualNewArrayNodeResult.iterator().hasNext());
    assertFalse(actualNewArrayNodeResult.elements().hasNext());
    assertTrue(actualNewArrayNodeResult.isContainerNode());
    assertTrue(actualNewArrayNodeResult.isArray());
    assertTrue(actualNewArrayNodeResult.isEmpty());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#newArrayNode(ObjectMapper)}
   */
  @Test
  void testNewArrayNode3() throws IOException {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializerFactory(mock(SerializerFactory.class));

    // Act
    ArrayNode actualNewArrayNodeResult = JacksonUtil.newArrayNode(mapper);

    // Assert
    JsonParser traverseResult = actualNewArrayNodeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("[ ]", actualNewArrayNodeResult.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualNewArrayNodeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.ARRAY, actualNewArrayNodeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualNewArrayNodeResult.isBigDecimal());
    assertFalse(actualNewArrayNodeResult.isBigInteger());
    assertFalse(actualNewArrayNodeResult.isBinary());
    assertFalse(actualNewArrayNodeResult.isBoolean());
    assertFalse(actualNewArrayNodeResult.isDouble());
    assertFalse(actualNewArrayNodeResult.isFloat());
    assertFalse(actualNewArrayNodeResult.isFloatingPointNumber());
    assertFalse(actualNewArrayNodeResult.isInt());
    assertFalse(actualNewArrayNodeResult.isIntegralNumber());
    assertFalse(actualNewArrayNodeResult.isLong());
    assertFalse(actualNewArrayNodeResult.isMissingNode());
    assertFalse(actualNewArrayNodeResult.isNull());
    assertFalse(actualNewArrayNodeResult.isNumber());
    assertFalse(actualNewArrayNodeResult.isObject());
    assertFalse(actualNewArrayNodeResult.isPojo());
    assertFalse(actualNewArrayNodeResult.isShort());
    assertFalse(actualNewArrayNodeResult.isTextual());
    assertFalse(actualNewArrayNodeResult.isValueNode());
    assertFalse(actualNewArrayNodeResult.iterator().hasNext());
    assertFalse(actualNewArrayNodeResult.elements().hasNext());
    assertTrue(actualNewArrayNodeResult.isContainerNode());
    assertTrue(actualNewArrayNodeResult.isArray());
    assertTrue(actualNewArrayNodeResult.isEmpty());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#clone(Object)}
   */
  @Test
  void testClone() {
    // Arrange, Act and Assert
    assertEquals("Value", JacksonUtil.clone("Value"));
    assertEquals("42", JacksonUtil.clone("42"));
    assertEquals("\"", JacksonUtil.clone("\""));
  }

  /**
   * Method under test: {@link JacksonUtil#valueToTree(Object)}
   */
  @Test
  void testValueToTree() throws IOException {
    // Arrange and Act
    JsonNode actualValueToTreeResult = JacksonUtil.valueToTree("Value");

    // Assert
    assertTrue(actualValueToTreeResult instanceof TextNode);
    JsonParser traverseResult = actualValueToTreeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"Value\"", actualValueToTreeResult.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualValueToTreeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.STRING, actualValueToTreeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualValueToTreeResult.isArray());
    assertFalse(actualValueToTreeResult.isBigDecimal());
    assertFalse(actualValueToTreeResult.isBigInteger());
    assertFalse(actualValueToTreeResult.isBinary());
    assertFalse(actualValueToTreeResult.isBoolean());
    assertFalse(actualValueToTreeResult.isContainerNode());
    assertFalse(actualValueToTreeResult.isDouble());
    assertFalse(actualValueToTreeResult.isFloat());
    assertFalse(actualValueToTreeResult.isFloatingPointNumber());
    assertFalse(actualValueToTreeResult.isInt());
    assertFalse(actualValueToTreeResult.isIntegralNumber());
    assertFalse(actualValueToTreeResult.isLong());
    assertFalse(actualValueToTreeResult.isMissingNode());
    assertFalse(actualValueToTreeResult.isNull());
    assertFalse(actualValueToTreeResult.isNumber());
    assertFalse(actualValueToTreeResult.isObject());
    assertFalse(actualValueToTreeResult.isPojo());
    assertFalse(actualValueToTreeResult.isShort());
    assertFalse(actualValueToTreeResult.iterator().hasNext());
    assertTrue(actualValueToTreeResult.isEmpty());
    assertTrue(actualValueToTreeResult.isTextual());
    assertTrue(actualValueToTreeResult.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#valueToTree(Object)}
   */
  @Test
  void testValueToTree2() throws IOException {
    // Arrange and Act
    JsonNode actualValueToTreeResult = JacksonUtil.valueToTree(null);

    // Assert
    assertTrue(actualValueToTreeResult instanceof NullNode);
    JsonParser traverseResult = actualValueToTreeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", actualValueToTreeResult.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualValueToTreeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, actualValueToTreeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualValueToTreeResult.isArray());
    assertFalse(actualValueToTreeResult.isBigDecimal());
    assertFalse(actualValueToTreeResult.isBigInteger());
    assertFalse(actualValueToTreeResult.isBinary());
    assertFalse(actualValueToTreeResult.isBoolean());
    assertFalse(actualValueToTreeResult.isContainerNode());
    assertFalse(actualValueToTreeResult.isDouble());
    assertFalse(actualValueToTreeResult.isFloat());
    assertFalse(actualValueToTreeResult.isFloatingPointNumber());
    assertFalse(actualValueToTreeResult.isInt());
    assertFalse(actualValueToTreeResult.isIntegralNumber());
    assertFalse(actualValueToTreeResult.isLong());
    assertFalse(actualValueToTreeResult.isMissingNode());
    assertFalse(actualValueToTreeResult.isNumber());
    assertFalse(actualValueToTreeResult.isObject());
    assertFalse(actualValueToTreeResult.isPojo());
    assertFalse(actualValueToTreeResult.isShort());
    assertFalse(actualValueToTreeResult.isTextual());
    assertFalse(actualValueToTreeResult.iterator().hasNext());
    assertTrue(actualValueToTreeResult.isEmpty());
    assertTrue(actualValueToTreeResult.isNull());
    assertTrue(actualValueToTreeResult.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#valueToTree(Object)}
   */
  @Test
  void testValueToTree3() throws IOException {
    // Arrange and Act
    JsonNode actualValueToTreeResult = JacksonUtil.<Object>valueToTree(42);

    // Assert
    assertTrue(actualValueToTreeResult instanceof IntNode);
    JsonParser traverseResult = actualValueToTreeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", actualValueToTreeResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualValueToTreeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, actualValueToTreeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualValueToTreeResult.isArray());
    assertFalse(actualValueToTreeResult.isBigDecimal());
    assertFalse(actualValueToTreeResult.isBigInteger());
    assertFalse(actualValueToTreeResult.isBinary());
    assertFalse(actualValueToTreeResult.isBoolean());
    assertFalse(actualValueToTreeResult.isContainerNode());
    assertFalse(actualValueToTreeResult.isDouble());
    assertFalse(actualValueToTreeResult.isFloat());
    assertFalse(actualValueToTreeResult.isFloatingPointNumber());
    assertFalse(actualValueToTreeResult.isLong());
    assertFalse(actualValueToTreeResult.isMissingNode());
    assertFalse(actualValueToTreeResult.isNull());
    assertFalse(actualValueToTreeResult.isObject());
    assertFalse(actualValueToTreeResult.isPojo());
    assertFalse(actualValueToTreeResult.isShort());
    assertFalse(actualValueToTreeResult.isTextual());
    assertFalse(((IntNode) actualValueToTreeResult).isNaN());
    assertFalse(actualValueToTreeResult.iterator().hasNext());
    assertTrue(actualValueToTreeResult.isEmpty());
    assertTrue(actualValueToTreeResult.isInt());
    assertTrue(actualValueToTreeResult.isIntegralNumber());
    assertTrue(actualValueToTreeResult.isNumber());
    assertTrue(actualValueToTreeResult.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#valueToTree(Object)}
   */
  @Test
  void testValueToTree4() throws IOException {
    // Arrange and Act
    JsonNode actualValueToTreeResult = JacksonUtil.<Object>valueToTree(1);

    // Assert
    assertTrue(actualValueToTreeResult instanceof IntNode);
    JsonParser traverseResult = actualValueToTreeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("1", actualValueToTreeResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualValueToTreeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, actualValueToTreeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualValueToTreeResult.isArray());
    assertFalse(actualValueToTreeResult.isBigDecimal());
    assertFalse(actualValueToTreeResult.isBigInteger());
    assertFalse(actualValueToTreeResult.isBinary());
    assertFalse(actualValueToTreeResult.isBoolean());
    assertFalse(actualValueToTreeResult.isContainerNode());
    assertFalse(actualValueToTreeResult.isDouble());
    assertFalse(actualValueToTreeResult.isFloat());
    assertFalse(actualValueToTreeResult.isFloatingPointNumber());
    assertFalse(actualValueToTreeResult.isLong());
    assertFalse(actualValueToTreeResult.isMissingNode());
    assertFalse(actualValueToTreeResult.isNull());
    assertFalse(actualValueToTreeResult.isObject());
    assertFalse(actualValueToTreeResult.isPojo());
    assertFalse(actualValueToTreeResult.isShort());
    assertFalse(actualValueToTreeResult.isTextual());
    assertFalse(((IntNode) actualValueToTreeResult).isNaN());
    assertFalse(actualValueToTreeResult.iterator().hasNext());
    assertTrue(actualValueToTreeResult.isEmpty());
    assertTrue(actualValueToTreeResult.isInt());
    assertTrue(actualValueToTreeResult.isIntegralNumber());
    assertTrue(actualValueToTreeResult.isNumber());
    assertTrue(actualValueToTreeResult.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#valueToTree(Object)}
   */
  @Test
  void testValueToTree5() throws IOException {
    // Arrange and Act
    JsonNode actualValueToTreeResult = JacksonUtil.valueToTree("");

    // Assert
    assertTrue(actualValueToTreeResult instanceof TextNode);
    JsonParser traverseResult = actualValueToTreeResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"\"", actualValueToTreeResult.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualValueToTreeResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.STRING, actualValueToTreeResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualValueToTreeResult.isArray());
    assertFalse(actualValueToTreeResult.isBigDecimal());
    assertFalse(actualValueToTreeResult.isBigInteger());
    assertFalse(actualValueToTreeResult.isBinary());
    assertFalse(actualValueToTreeResult.isBoolean());
    assertFalse(actualValueToTreeResult.isContainerNode());
    assertFalse(actualValueToTreeResult.isDouble());
    assertFalse(actualValueToTreeResult.isFloat());
    assertFalse(actualValueToTreeResult.isFloatingPointNumber());
    assertFalse(actualValueToTreeResult.isInt());
    assertFalse(actualValueToTreeResult.isIntegralNumber());
    assertFalse(actualValueToTreeResult.isLong());
    assertFalse(actualValueToTreeResult.isMissingNode());
    assertFalse(actualValueToTreeResult.isNull());
    assertFalse(actualValueToTreeResult.isNumber());
    assertFalse(actualValueToTreeResult.isObject());
    assertFalse(actualValueToTreeResult.isPojo());
    assertFalse(actualValueToTreeResult.isShort());
    assertFalse(actualValueToTreeResult.iterator().hasNext());
    assertTrue(actualValueToTreeResult.isEmpty());
    assertTrue(actualValueToTreeResult.isTextual());
    assertTrue(actualValueToTreeResult.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  void testWriteValueAsBytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualWriteValueAsBytesResult = JacksonUtil.writeValueAsBytes(null);

    // Assert
    assertArrayEquals("null".getBytes("UTF-8"), actualWriteValueAsBytesResult);
  }

  /**
   * Method under test: {@link JacksonUtil#writeValueAsBytes(Object)}
   */
  @Test
  void testWriteValueAsBytes2() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'4', '2'}, JacksonUtil.<Object>writeValueAsBytes(42));
  }

  /**
   * Method under test: {@link JacksonUtil#getSafely(JsonNode, String[])}
   */
  @Test
  void testGetSafely() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.getSafely(MissingNode.getInstance(), "Path"));
    assertNull(JacksonUtil.getSafely(null, "Path"));
    assertNull(JacksonUtil.getSafely(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)), "Path"));
  }

  /**
   * Method under test: {@link JacksonUtil#getSafely(JsonNode, String[])}
   */
  @Test
  void testGetSafely2() throws IOException {
    // Arrange and Act
    JsonNode actualSafely = JacksonUtil.getSafely(MissingNode.getInstance());

    // Assert
    assertTrue(actualSafely instanceof MissingNode);
    JsonParser traverseResult = actualSafely.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("", actualSafely.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualSafely.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.MISSING, actualSafely.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualSafely.isArray());
    assertFalse(actualSafely.isBigDecimal());
    assertFalse(actualSafely.isBigInteger());
    assertFalse(actualSafely.isBinary());
    assertFalse(actualSafely.isBoolean());
    assertFalse(actualSafely.isContainerNode());
    assertFalse(actualSafely.isDouble());
    assertFalse(actualSafely.isFloat());
    assertFalse(actualSafely.isFloatingPointNumber());
    assertFalse(actualSafely.isInt());
    assertFalse(actualSafely.isIntegralNumber());
    assertFalse(actualSafely.isLong());
    assertFalse(actualSafely.isNull());
    assertFalse(actualSafely.isNumber());
    assertFalse(actualSafely.isObject());
    assertFalse(actualSafely.isPojo());
    assertFalse(actualSafely.isShort());
    assertFalse(actualSafely.isTextual());
    assertFalse(actualSafely.isValueNode());
    assertFalse(actualSafely.iterator().hasNext());
    assertTrue(actualSafely.isEmpty());
    assertTrue(actualSafely.isMissingNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#asObject(JsonNode)}
   */
  @Test
  void testAsObject() throws IOException {
    // Arrange and Act
    ObjectNode actualAsObjectResult = JacksonUtil.asObject(MissingNode.getInstance());

    // Assert
    JsonParser traverseResult = actualAsObjectResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", actualAsObjectResult.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualAsObjectResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, actualAsObjectResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualAsObjectResult.isArray());
    assertFalse(actualAsObjectResult.isBigDecimal());
    assertFalse(actualAsObjectResult.isBigInteger());
    assertFalse(actualAsObjectResult.isBinary());
    assertFalse(actualAsObjectResult.isBoolean());
    assertFalse(actualAsObjectResult.isDouble());
    assertFalse(actualAsObjectResult.isFloat());
    assertFalse(actualAsObjectResult.isFloatingPointNumber());
    assertFalse(actualAsObjectResult.isInt());
    assertFalse(actualAsObjectResult.isIntegralNumber());
    assertFalse(actualAsObjectResult.isLong());
    assertFalse(actualAsObjectResult.isMissingNode());
    assertFalse(actualAsObjectResult.isNull());
    assertFalse(actualAsObjectResult.isNumber());
    assertFalse(actualAsObjectResult.isPojo());
    assertFalse(actualAsObjectResult.isShort());
    assertFalse(actualAsObjectResult.isTextual());
    assertFalse(actualAsObjectResult.isValueNode());
    assertFalse(actualAsObjectResult.iterator().hasNext());
    assertTrue(actualAsObjectResult.isContainerNode());
    assertTrue(actualAsObjectResult.isEmpty());
    assertTrue(actualAsObjectResult.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JacksonUtil#asObject(JsonNode)}
   */
  @Test
  void testAsObject2() throws IOException {
    // Arrange and Act
    ObjectNode actualAsObjectResult = JacksonUtil.asObject(null);

    // Assert
    JsonParser traverseResult = actualAsObjectResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", actualAsObjectResult.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, actualAsObjectResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, actualAsObjectResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualAsObjectResult.isArray());
    assertFalse(actualAsObjectResult.isBigDecimal());
    assertFalse(actualAsObjectResult.isBigInteger());
    assertFalse(actualAsObjectResult.isBinary());
    assertFalse(actualAsObjectResult.isBoolean());
    assertFalse(actualAsObjectResult.isDouble());
    assertFalse(actualAsObjectResult.isFloat());
    assertFalse(actualAsObjectResult.isFloatingPointNumber());
    assertFalse(actualAsObjectResult.isInt());
    assertFalse(actualAsObjectResult.isIntegralNumber());
    assertFalse(actualAsObjectResult.isLong());
    assertFalse(actualAsObjectResult.isMissingNode());
    assertFalse(actualAsObjectResult.isNull());
    assertFalse(actualAsObjectResult.isNumber());
    assertFalse(actualAsObjectResult.isPojo());
    assertFalse(actualAsObjectResult.isShort());
    assertFalse(actualAsObjectResult.isTextual());
    assertFalse(actualAsObjectResult.isValueNode());
    assertFalse(actualAsObjectResult.iterator().hasNext());
    assertTrue(actualAsObjectResult.isContainerNode());
    assertTrue(actualAsObjectResult.isEmpty());
    assertTrue(actualAsObjectResult.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)}
   */
  @Test
  void testReplaceUuidsRecursively() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.add("99999999-9999-9999-9999-999999999999");
    node.add("");
    node.add(MissingNode.getInstance());
    HashSet<String> skippedRootFields = new HashSet<>();
    UnaryOperator<UUID> replacer = mock(UnaryOperator.class);
    when(replacer.apply(Mockito.<UUID>any())).thenReturn(UUID.randomUUID());

    // Act
    JacksonUtil.replaceUuidsRecursively(node, skippedRootFields, RegexUtils.UUID_PATTERN, replacer, true);

    // Assert
    verify(replacer).apply(isA(UUID.class));
  }

  /**
   * Method under test:
   * {@link JacksonUtil#replaceUuidsRecursively(JsonNode, Set, Pattern, UnaryOperator, boolean)}
   */
  @Test
  void testReplaceUuidsRecursively2() {
    // Arrange
    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    node.add("99999999-9999-9999-9999-99999999999999999999-9999-9999-9999-999999999999");
    node.add("");
    node.add(MissingNode.getInstance());
    HashSet<String> skippedRootFields = new HashSet<>();
    UnaryOperator<UUID> replacer = mock(UnaryOperator.class);
    when(replacer.apply(Mockito.<UUID>any())).thenReturn(UUID.randomUUID());

    // Act
    JacksonUtil.replaceUuidsRecursively(node, skippedRootFields, RegexUtils.UUID_PATTERN, replacer, true);

    // Assert
    verify(replacer, atLeast(1)).apply(isA(UUID.class));
  }

  /**
   * Method under test: {@link JacksonUtil#toFlatMap(JsonNode)}
   */
  @Test
  void testToFlatMap() {
    // Arrange and Act
    Map<String, String> actualToFlatMapResult = JacksonUtil.toFlatMap(MissingNode.getInstance());

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Method under test: {@link JacksonUtil#toFlatMap(JsonNode)}
   */
  @Test
  void testToFlatMap2() {
    // Arrange and Act
    Map<String, String> actualToFlatMapResult = JacksonUtil
        .toFlatMap(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Method under test: {@link JacksonUtil#toFlatMap(JsonNode)}
   */
  @Test
  void testToFlatMap3() {
    // Arrange and Act
    Map<String, String> actualToFlatMapResult = JacksonUtil.toFlatMap(new BigIntegerNode(BigInteger.valueOf(1L)));

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("1", actualToFlatMapResult.get(""));
  }

  /**
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  void testFromReader() {
    // Arrange
    StringReader reader = new StringReader("foo");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  void testFromReader2() {
    // Arrange, Act and Assert
    assertNull(JacksonUtil.fromReader(null, null));
  }

  /**
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  void testFromReader3() {
    // Arrange
    StringReader reader = new StringReader("Invalid request payload");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  void testFromReader4() {
    // Arrange
    StringReader reader = new StringReader("");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  void testFromReader5() {
    // Arrange
    CharArrayReader reader = new CharArrayReader("A\u0000A\u0000".toCharArray(), 1, 1);

    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  void testFromReader6() {
    // Arrange
    StringReader reader = new StringReader("foo");
    Class<JsonMapper.Builder> clazz = JsonMapper.Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  void testFromReader7() {
    // Arrange
    StringReader reader = new StringReader("foo");
    Class<String> clazz = String.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  void testFromReader8() {
    // Arrange
    StringReader reader = new StringReader("42");
    Class<JsonMapper.Builder> clazz = JsonMapper.Builder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  void testFromReader9() {
    // Arrange
    StringReader reader = new StringReader("42");
    Class<String> clazz = String.class;

    // Act and Assert
    assertEquals("42", JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#fromReader(Reader, Class)}
   */
  @Test
  void testFromReader10() {
    // Arrange
    StringReader reader = new StringReader("42");
    Class<JacksonUtil> clazz = JacksonUtil.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.fromReader(reader, clazz));
  }

  /**
   * Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  void testWriteValue() {
    // Arrange
    StringWriter writer = new StringWriter();

    // Act
    JacksonUtil.writeValue(writer, "Value");

    // Assert
    assertEquals("\"Value\"", writer.toString());
  }

  /**
   * Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  void testWriteValue2() {
    // Arrange
    StringWriter writer = new StringWriter();

    // Act
    JacksonUtil.writeValue(writer, null);

    // Assert
    assertEquals("null", writer.toString());
  }

  /**
   * Method under test: {@link JacksonUtil#writeValue(Writer, Object)}
   */
  @Test
  void testWriteValue3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.writeValue(new PipedWriter(), "Value"));
  }

  /**
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  void testAddKvEntry() throws IOException {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "42"));

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof IntNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", nextResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("{\n  \"Key\" : 42\n}", entityNode.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, entityNode.size());
    assertEquals(JsonNodeType.NUMBER, nextResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(((IntNode) nextResult).isNaN());
    assertFalse(entityNode.isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isInt());
    assertTrue(nextResult.isIntegralNumber());
    assertTrue(nextResult.isNumber());
    assertTrue(nextResult.isValueNode());
  }

  /**
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  void testAddKvEntry2() throws IOException {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(false));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "42"));

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof IntNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", nextResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("{\n  \"Key\" : 42\n}", entityNode.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, entityNode.size());
    assertEquals(JsonNodeType.NUMBER, nextResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(((IntNode) nextResult).isNaN());
    assertFalse(entityNode.isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isInt());
    assertTrue(nextResult.isIntegralNumber());
    assertTrue(nextResult.isNumber());
    assertTrue(nextResult.isValueNode());
  }

  /**
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  void testAddKvEntry3() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "Value")));
  }

  /**
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  void testAddKvEntry4() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", null));

    // Assert
    assertEquals("{ }", entityNode.toPrettyString());
    assertEquals(0, entityNode.size());
    assertFalse(entityNode.iterator().hasNext());
    assertTrue(entityNode.isEmpty());
  }

  /**
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  void testAddKvEntry5() throws IOException {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", ""));

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof NullNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("null", nextResult.toPrettyString());
    assertEquals("{\n  \"Key\" : null\n}", entityNode.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, entityNode.size());
    assertEquals(JsonNodeType.NULL, nextResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(entityNode.isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isNull());
    assertTrue(nextResult.isValueNode());
  }

  /**
   * Method under test: {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry)}
   */
  @Test
  void testAddKvEntry6() throws IOException {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new StringDataEntry("Key", "42"));

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"42\"", nextResult.toPrettyString());
    assertEquals("{\n  \"Key\" : \"42\"\n}", entityNode.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, entityNode.size());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(entityNode.isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isTextual());
    assertTrue(nextResult.isValueNode());
  }

  /**
   * Method under test:
   * {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  void testAddKvEntry7() throws IOException {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "42"), "Key");

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof IntNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", nextResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("{\n  \"Key\" : 42\n}", entityNode.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, entityNode.size());
    assertEquals(JsonNodeType.NUMBER, nextResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(((IntNode) nextResult).isNaN());
    assertFalse(entityNode.isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isInt());
    assertTrue(nextResult.isIntegralNumber());
    assertTrue(nextResult.isNumber());
    assertTrue(nextResult.isValueNode());
  }

  /**
   * Method under test:
   * {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  void testAddKvEntry8() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "Value"), "Key"));
  }

  /**
   * Method under test:
   * {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  void testAddKvEntry9() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", null), "Key");

    // Assert
    assertEquals("{ }", entityNode.toPrettyString());
    assertEquals(0, entityNode.size());
    assertFalse(entityNode.iterator().hasNext());
    assertTrue(entityNode.isEmpty());
  }

  /**
   * Method under test:
   * {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  void testAddKvEntry10() throws IOException {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", ""), "Key");

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof NullNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("null", nextResult.toPrettyString());
    assertEquals("{\n  \"Key\" : null\n}", entityNode.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, entityNode.size());
    assertEquals(JsonNodeType.NULL, nextResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(entityNode.isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isNull());
    assertTrue(nextResult.isValueNode());
  }

  /**
   * Method under test:
   * {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String)}
   */
  @Test
  void testAddKvEntry11() throws IOException {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new StringDataEntry("Key", "42"), "Key");

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"42\"", nextResult.toPrettyString());
    assertEquals("{\n  \"Key\" : \"42\"\n}", entityNode.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, entityNode.size());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(entityNode.isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isTextual());
    assertTrue(nextResult.isValueNode());
  }

  /**
   * Method under test:
   * {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  void testAddKvEntry12() throws IOException {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "42"), "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof IntNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", nextResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("{\n  \"Key\" : 42\n}", entityNode.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, entityNode.size());
    assertEquals(JsonNodeType.NUMBER, nextResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(((IntNode) nextResult).isNaN());
    assertFalse(entityNode.isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isInt());
    assertTrue(nextResult.isIntegralNumber());
    assertTrue(nextResult.isNumber());
    assertTrue(nextResult.isValueNode());
  }

  /**
   * Method under test:
   * {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  void testAddKvEntry13() throws IOException {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(false));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", "42"), "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof IntNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", nextResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("{\n  \"Key\" : 42\n}", entityNode.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, entityNode.size());
    assertEquals(JsonNodeType.NUMBER, nextResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(((IntNode) nextResult).isNaN());
    assertFalse(entityNode.isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isInt());
    assertTrue(nextResult.isIntegralNumber());
    assertTrue(nextResult.isNumber());
    assertTrue(nextResult.isValueNode());
  }

  /**
   * Method under test:
   * {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  void testAddKvEntry14() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JacksonUtil.addKvEntry(entityNode,
        new JsonDataEntry("Key", "Value"), "Key", JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER));
  }

  /**
   * Method under test:
   * {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  void testAddKvEntry15() {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", null), "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    assertEquals("{ }", entityNode.toPrettyString());
    assertEquals(0, entityNode.size());
    assertFalse(entityNode.iterator().hasNext());
    assertTrue(entityNode.isEmpty());
  }

  /**
   * Method under test:
   * {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  void testAddKvEntry16() throws IOException {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new JsonDataEntry("Key", ""), "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof NullNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("null", nextResult.toPrettyString());
    assertEquals("{\n  \"Key\" : null\n}", entityNode.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, entityNode.size());
    assertEquals(JsonNodeType.NULL, nextResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(entityNode.isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isNull());
    assertTrue(nextResult.isValueNode());
  }

  /**
   * Method under test:
   * {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  void testAddKvEntry17() throws IOException {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    JacksonUtil.addKvEntry(entityNode, new StringDataEntry("Key", "42"), "Key",
        JacksonUtil.IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER);

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"42\"", nextResult.toPrettyString());
    assertEquals("{\n  \"Key\" : \"42\"\n}", entityNode.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, entityNode.size());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(entityNode.isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isTextual());
    assertTrue(nextResult.isValueNode());
  }

  /**
   * Method under test:
   * {@link JacksonUtil#addKvEntry(ObjectNode, KvEntry, String, ObjectMapper)}
   */
  @Test
  void testAddKvEntry18() throws IOException {
    // Arrange
    ObjectNode entityNode = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));
    JsonDataEntry kvEntry = new JsonDataEntry("Key", "42");

    // Act
    JacksonUtil.addKvEntry(entityNode, kvEntry, "Key", new ObjectMapper());

    // Assert
    Iterator<JsonNode> iteratorResult = entityNode.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof IntNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", nextResult.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("{\n  \"Key\" : 42\n}", entityNode.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, entityNode.size());
    assertEquals(JsonNodeType.NUMBER, nextResult.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(((IntNode) nextResult).isNaN());
    assertFalse(entityNode.isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertFalse(nextResult.iterator().hasNext());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isInt());
    assertTrue(nextResult.isIntegralNumber());
    assertTrue(nextResult.isNumber());
    assertTrue(nextResult.isValueNode());
  }
}
