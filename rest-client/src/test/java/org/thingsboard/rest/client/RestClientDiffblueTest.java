package org.thingsboard.rest.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.PrettyPrinter;
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
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
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
import io.micrometer.observation.ObservationRegistry;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.InterceptingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.client.support.InterceptingHttpAccessor;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriTemplateHandler;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.EntityRelationInfo;
import org.thingsboard.server.common.data.relation.EntityRelationsQuery;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationEntityTypeFilter;
import org.thingsboard.server.common.data.relation.RelationsSearchParameters;

class RestClientDiffblueTest {
  /**
   * Test {@link RestClient#RestClient(String)}.
   * <p>
   * Method under test: {@link RestClient#RestClient(String)}
   */
  @Test
  @DisplayName("Test new RestClient(String)")
  void testNewRestClient() throws MissingResourceException {
    // Arrange and Act
    RestClient actualRestClient = new RestClient("https://example.org/example");

    // Assert
    RestTemplate restTemplate = actualRestClient.getRestTemplate();
    List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
    assertEquals(5, messageConverters.size());
    HttpMessageConverter<?> getResult = messageConverters.get(4);
    ObjectMapper objectMapper = ((MappingJackson2HttpMessageConverter) getResult).getObjectMapper();
    SerializationConfig serializationConfig = objectMapper.getSerializationConfig();
    PrettyPrinter defaultPrettyPrinter = serializationConfig.getDefaultPrettyPrinter();
    assertTrue(defaultPrettyPrinter instanceof DefaultPrettyPrinter);
    HttpMessageConverter<?> getResult2 = messageConverters.get(3);
    List<HttpMessageConverter<?>> partConverters = ((AllEncompassingFormHttpMessageConverter) getResult2)
        .getPartConverters();
    assertEquals(4, partConverters.size());
    HttpMessageConverter<?> getResult3 = partConverters.get(3);
    ObjectMapper objectMapper2 = ((MappingJackson2HttpMessageConverter) getResult3).getObjectMapper();
    JsonFactory factory = objectMapper2.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    RestTemplate restTemplate2 = actualRestClient.loginRestTemplate;
    List<HttpMessageConverter<?>> messageConverters2 = restTemplate2.getMessageConverters();
    assertEquals(5, messageConverters2.size());
    HttpMessageConverter<?> getResult4 = messageConverters2.get(3);
    List<HttpMessageConverter<?>> partConverters2 = ((AllEncompassingFormHttpMessageConverter) getResult4)
        .getPartConverters();
    assertEquals(4, partConverters2.size());
    HttpMessageConverter<?> getResult5 = partConverters2.get(3);
    ObjectMapper objectMapper3 = ((MappingJackson2HttpMessageConverter) getResult5).getObjectMapper();
    JsonFactory factory2 = objectMapper3.getFactory();
    assertTrue(factory2 instanceof MappingJsonFactory);
    JsonFactory factory3 = objectMapper.getFactory();
    assertTrue(factory3 instanceof MappingJsonFactory);
    HttpMessageConverter<?> getResult6 = messageConverters2.get(4);
    ObjectMapper objectMapper4 = ((MappingJackson2HttpMessageConverter) getResult6).getObjectMapper();
    JsonFactory factory4 = objectMapper4.getFactory();
    assertTrue(factory4 instanceof MappingJsonFactory);
    DeserializationConfig deserializationConfig = objectMapper.getDeserializationConfig();
    ContextAttributes attributes = deserializationConfig.getAttributes();
    assertTrue(attributes instanceof ContextAttributes.Impl);
    CacheProvider cacheProvider = deserializationConfig.getCacheProvider();
    assertTrue(cacheProvider instanceof DefaultCacheProvider);
    DeserializationContext deserializationContext = objectMapper2.getDeserializationContext();
    assertTrue(deserializationContext.getFactory() instanceof BeanDeserializerFactory);
    DeserializationContext deserializationContext2 = objectMapper3.getDeserializationContext();
    assertTrue(deserializationContext2.getFactory() instanceof BeanDeserializerFactory);
    DeserializationContext deserializationContext3 = objectMapper.getDeserializationContext();
    DeserializerFactory factory5 = deserializationContext3.getFactory();
    assertTrue(factory5 instanceof BeanDeserializerFactory);
    DeserializationContext deserializationContext4 = objectMapper4.getDeserializationContext();
    DeserializerFactory factory6 = deserializationContext4.getFactory();
    assertTrue(factory6 instanceof BeanDeserializerFactory);
    assertTrue(deserializationContext instanceof DefaultDeserializationContext.Impl);
    assertTrue(deserializationContext2 instanceof DefaultDeserializationContext.Impl);
    assertTrue(deserializationContext3 instanceof DefaultDeserializationContext.Impl);
    assertTrue(deserializationContext4 instanceof DefaultDeserializationContext.Impl);
    DeserializationConfig deserializationConfig2 = objectMapper2.getDeserializationConfig();
    assertTrue(deserializationConfig2.getClassIntrospector() instanceof BasicClassIntrospector);
    DeserializationConfig deserializationConfig3 = objectMapper3.getDeserializationConfig();
    assertTrue(deserializationConfig3.getClassIntrospector() instanceof BasicClassIntrospector);
    ClassIntrospector classIntrospector = deserializationConfig.getClassIntrospector();
    assertTrue(classIntrospector instanceof BasicClassIntrospector);
    DeserializationConfig deserializationConfig4 = objectMapper4.getDeserializationConfig();
    ClassIntrospector classIntrospector2 = deserializationConfig4.getClassIntrospector();
    assertTrue(classIntrospector2 instanceof BasicClassIntrospector);
    AccessorNamingStrategy.Provider accessorNaming = deserializationConfig.getAccessorNaming();
    assertTrue(accessorNaming instanceof DefaultAccessorNamingStrategy.Provider);
    AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
    assertTrue(annotationIntrospector instanceof JacksonAnnotationIntrospector);
    VisibilityChecker<?> visibilityChecker = objectMapper.getVisibilityChecker();
    assertTrue(visibilityChecker instanceof VisibilityChecker.Std);
    PolymorphicTypeValidator polymorphicTypeValidator = objectMapper.getPolymorphicTypeValidator();
    assertTrue(polymorphicTypeValidator instanceof LaissezFaireSubTypeValidator);
    assertTrue(objectMapper2.getSubtypeResolver() instanceof StdSubtypeResolver);
    assertTrue(objectMapper3.getSubtypeResolver() instanceof StdSubtypeResolver);
    SubtypeResolver subtypeResolver = objectMapper.getSubtypeResolver();
    assertTrue(subtypeResolver instanceof StdSubtypeResolver);
    SubtypeResolver subtypeResolver2 = objectMapper4.getSubtypeResolver();
    assertTrue(subtypeResolver2 instanceof StdSubtypeResolver);
    DeserializerFactoryConfig factoryConfig = ((BeanDeserializerFactory) factory5).getFactoryConfig();
    Iterable<Deserializers> deserializersResult = factoryConfig.deserializers();
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult).next() instanceof SimpleDeserializers);
    DeserializerFactoryConfig factoryConfig2 = ((BeanDeserializerFactory) factory6).getFactoryConfig();
    Iterable<Deserializers> deserializersResult2 = factoryConfig2.deserializers();
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult2).next() instanceof SimpleDeserializers);
    SerializerFactory serializerFactory = objectMapper2.getSerializerFactory();
    SerializerFactoryConfig factoryConfig3 = ((BeanSerializerFactory) serializerFactory).getFactoryConfig();
    Iterable<Serializers> serializersResult = factoryConfig3.serializers();
    assertTrue(((ArrayIterator<Serializers>) serializersResult).next() instanceof SimpleSerializers);
    SerializerFactory serializerFactory2 = objectMapper3.getSerializerFactory();
    SerializerFactoryConfig factoryConfig4 = ((BeanSerializerFactory) serializerFactory2).getFactoryConfig();
    Iterable<Serializers> serializersResult2 = factoryConfig4.serializers();
    assertTrue(((ArrayIterator<Serializers>) serializersResult2).next() instanceof SimpleSerializers);
    SerializerFactory serializerFactory3 = objectMapper.getSerializerFactory();
    SerializerFactoryConfig factoryConfig5 = ((BeanSerializerFactory) serializerFactory3).getFactoryConfig();
    Iterable<Serializers> serializersResult3 = factoryConfig5.serializers();
    assertTrue(((ArrayIterator<Serializers>) serializersResult3).next() instanceof SimpleSerializers);
    SerializerFactory serializerFactory4 = objectMapper4.getSerializerFactory();
    SerializerFactoryConfig factoryConfig6 = ((BeanSerializerFactory) serializerFactory4).getFactoryConfig();
    Iterable<Serializers> serializersResult4 = factoryConfig6.serializers();
    assertTrue(((ArrayIterator<Serializers>) serializersResult4).next() instanceof SimpleSerializers);
    assertTrue(serializerFactory instanceof BeanSerializerFactory);
    assertTrue(serializerFactory2 instanceof BeanSerializerFactory);
    assertTrue(serializerFactory3 instanceof BeanSerializerFactory);
    assertTrue(serializerFactory4 instanceof BeanSerializerFactory);
    SerializerProvider serializerProvider = objectMapper2.getSerializerProvider();
    assertTrue(serializerProvider instanceof DefaultSerializerProvider.Impl);
    SerializerProvider serializerProvider2 = objectMapper3.getSerializerProvider();
    assertTrue(serializerProvider2 instanceof DefaultSerializerProvider.Impl);
    SerializerProvider serializerProvider3 = objectMapper.getSerializerProvider();
    assertTrue(serializerProvider3 instanceof DefaultSerializerProvider.Impl);
    SerializerProvider serializerProvider4 = objectMapper4.getSerializerProvider();
    assertTrue(serializerProvider4 instanceof DefaultSerializerProvider.Impl);
    SerializerProvider serializerProviderInstance = objectMapper2.getSerializerProviderInstance();
    assertTrue(serializerProviderInstance instanceof DefaultSerializerProvider.Impl);
    SerializerProvider serializerProviderInstance2 = objectMapper3.getSerializerProviderInstance();
    assertTrue(serializerProviderInstance2 instanceof DefaultSerializerProvider.Impl);
    SerializerProvider serializerProviderInstance3 = objectMapper.getSerializerProviderInstance();
    assertTrue(serializerProviderInstance3 instanceof DefaultSerializerProvider.Impl);
    SerializerProvider serializerProviderInstance4 = objectMapper4.getSerializerProviderInstance();
    assertTrue(serializerProviderInstance4 instanceof DefaultSerializerProvider.Impl);
    JsonSerializer<Object> defaultNullKeySerializer = serializerProvider3.getDefaultNullKeySerializer();
    assertTrue(defaultNullKeySerializer instanceof FailingSerializer);
    JsonSerializer<Object> defaultNullValueSerializer = serializerProvider3.getDefaultNullValueSerializer();
    assertTrue(defaultNullValueSerializer instanceof NullSerializer);
    assertTrue(deserializersResult instanceof ArrayIterator);
    assertTrue(deserializersResult2 instanceof ArrayIterator);
    assertTrue(serializersResult instanceof ArrayIterator);
    assertTrue(serializersResult2 instanceof ArrayIterator);
    assertTrue(serializersResult3 instanceof ArrayIterator);
    assertTrue(serializersResult4 instanceof ArrayIterator);
    DateFormat dateFormat = objectMapper.getDateFormat();
    assertTrue(dateFormat instanceof StdDateFormat);
    ClientHttpRequestFactory requestFactory = restTemplate.getRequestFactory();
    assertTrue(requestFactory instanceof InterceptingClientHttpRequestFactory);
    ClientHttpRequestFactory requestFactory2 = restTemplate2.getRequestFactory();
    assertTrue(requestFactory2 instanceof SimpleClientHttpRequestFactory);
    HttpMessageConverter<?> getResult7 = partConverters.get(0);
    assertTrue(getResult7 instanceof ByteArrayHttpMessageConverter);
    HttpMessageConverter<?> getResult8 = partConverters2.get(0);
    assertTrue(getResult8 instanceof ByteArrayHttpMessageConverter);
    HttpMessageConverter<?> getResult9 = messageConverters.get(0);
    assertTrue(getResult9 instanceof ByteArrayHttpMessageConverter);
    HttpMessageConverter<?> getResult10 = messageConverters2.get(0);
    assertTrue(getResult10 instanceof ByteArrayHttpMessageConverter);
    HttpMessageConverter<?> getResult11 = partConverters.get(2);
    assertTrue(getResult11 instanceof ResourceHttpMessageConverter);
    HttpMessageConverter<?> getResult12 = partConverters2.get(2);
    assertTrue(getResult12 instanceof ResourceHttpMessageConverter);
    HttpMessageConverter<?> getResult13 = partConverters.get(1);
    assertTrue(getResult13 instanceof StringHttpMessageConverter);
    HttpMessageConverter<?> getResult14 = partConverters2.get(1);
    assertTrue(getResult14 instanceof StringHttpMessageConverter);
    HttpMessageConverter<?> getResult15 = messageConverters.get(1);
    assertTrue(getResult15 instanceof StringHttpMessageConverter);
    HttpMessageConverter<?> getResult16 = messageConverters2.get(1);
    assertTrue(getResult16 instanceof StringHttpMessageConverter);
    assertTrue(getResult3 instanceof MappingJackson2HttpMessageConverter);
    assertTrue(getResult5 instanceof MappingJackson2HttpMessageConverter);
    assertTrue(getResult instanceof MappingJackson2HttpMessageConverter);
    assertTrue(getResult6 instanceof MappingJackson2HttpMessageConverter);
    assertTrue(getResult2 instanceof AllEncompassingFormHttpMessageConverter);
    assertTrue(getResult4 instanceof AllEncompassingFormHttpMessageConverter);
    assertTrue(restTemplate.getErrorHandler() instanceof DefaultResponseErrorHandler);
    assertTrue(restTemplate2.getErrorHandler() instanceof DefaultResponseErrorHandler);
    UriTemplateHandler uriTemplateHandler = restTemplate.getUriTemplateHandler();
    assertTrue(uriTemplateHandler instanceof DefaultUriBuilderFactory);
    UriTemplateHandler uriTemplateHandler2 = restTemplate2.getUriTemplateHandler();
    assertTrue(uriTemplateHandler2 instanceof DefaultUriBuilderFactory);
    assertEquals(" ", factory.getRootValueSeparator());
    assertEquals(" ", factory2.getRootValueSeparator());
    assertEquals(" ", factory3.getRootValueSeparator());
    assertEquals(" ", factory4.getRootValueSeparator());
    Locale locale = deserializationConfig.getLocale();
    assertEquals("", locale.getDisplayScript());
    assertEquals("", locale.getDisplayVariant());
    assertEquals("", locale.getScript());
    assertEquals("", locale.getVariant());
    List<MediaType> supportedMediaTypes = getResult9.getSupportedMediaTypes();
    assertEquals(2, supportedMediaTypes.size());
    MediaType getResult17 = supportedMediaTypes.get(1);
    assertEquals("*", getResult17.getSubtype());
    assertEquals("*", getResult17.getType());
    List<MediaType> supportedMediaTypes2 = getResult.getSupportedMediaTypes();
    assertEquals(2, supportedMediaTypes2.size());
    MediaType getResult18 = supportedMediaTypes2.get(1);
    assertEquals("*+json", getResult18.getSubtype());
    TimeZone timeZone = deserializationConfig.getTimeZone();
    assertEquals("Coordinated Universal Time", timeZone.getDisplayName());
    assertEquals("English (United Kingdom)", locale.getDisplayName());
    assertEquals("English", locale.getDisplayLanguage());
    assertEquals("GB", locale.getCountry());
    assertEquals("GBR", locale.getISO3Country());
    Charset defaultCharset = ((StringHttpMessageConverter) getResult15).getDefaultCharset();
    assertEquals("ISO-8859-1", defaultCharset.name());
    assertEquals("JSON", factory.getFormatName());
    assertEquals("JSON", factory2.getFormatName());
    assertEquals("JSON", factory3.getFormatName());
    assertEquals("JSON", factory4.getFormatName());
    Base64Variant base64Variant = deserializationConfig.getBase64Variant();
    assertEquals("MIME-NO-LINEFEEDS", base64Variant.getName());
    assertEquals("MIME-NO-LINEFEEDS", base64Variant.toString());
    assertEquals("UTC", timeZone.getID());
    Charset defaultCharset2 = ((StringHttpMessageConverter) getResult13).getDefaultCharset();
    assertEquals("UTF-8", defaultCharset2.name());
    assertEquals("United Kingdom", locale.getDisplayCountry());
    assertEquals("[one of: 'yyyy-MM-dd'T'HH:mm:ss.SSSX', 'EEE, dd MMM yyyy HH:mm:ss zzz' (lenient)]",
        ((StdDateFormat) dateFormat).toPattern());
    MediaType getResult19 = supportedMediaTypes.get(0);
    assertEquals("application", getResult19.getType());
    List<MediaType> supportedMediaTypes3 = getResult2.getSupportedMediaTypes();
    assertEquals(4, supportedMediaTypes3.size());
    MediaType getResult20 = supportedMediaTypes3.get(0);
    assertEquals("application", getResult20.getType());
    MediaType getResult21 = supportedMediaTypes2.get(0);
    assertEquals("application", getResult21.getType());
    assertEquals("application", getResult18.getType());
    Version versionResult = factory3.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    Version versionResult2 = objectMapper.version();
    assertEquals("com.fasterxml.jackson.core", versionResult2.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-core/2.17.2", versionResult.toFullString());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult2.toFullString());
    assertEquals("en", locale.getLanguage());
    assertEquals("eng", locale.getISO3Language());
    MediaType getResult22 = supportedMediaTypes3.get(1);
    assertEquals("form-data", getResult22.getSubtype());
    assertEquals("https://example.org/example", actualRestClient.baseURL);
    assertEquals("jackson-core", versionResult.getArtifactId());
    assertEquals("jackson-databind", versionResult2.getArtifactId());
    assertEquals("json", getResult21.getSubtype());
    assertEquals("json", getResult18.getSubtypeSuffix());
    MediaType getResult23 = supportedMediaTypes3.get(2);
    assertEquals("mixed", getResult23.getSubtype());
    assertEquals("multipart", getResult22.getType());
    assertEquals("multipart", getResult23.getType());
    MediaType getResult24 = supportedMediaTypes3.get(3);
    assertEquals("multipart", getResult24.getType());
    assertEquals("octet-stream", getResult19.getSubtype());
    List<MediaType> supportedMediaTypes4 = getResult15.getSupportedMediaTypes();
    assertEquals(2, supportedMediaTypes4.size());
    MediaType getResult25 = supportedMediaTypes4.get(0);
    assertEquals("plain", getResult25.getSubtype());
    assertEquals("related", getResult24.getSubtype());
    assertEquals("text", getResult25.getType());
    assertEquals("x-www-form-urlencoded", getResult20.getSubtype());
    assertEquals('=', base64Variant.getPaddingChar());
    assertNull(serializerProvider.getGenerator());
    assertNull(serializerProvider2.getGenerator());
    assertNull(serializerProvider3.getGenerator());
    assertNull(serializerProvider4.getGenerator());
    assertNull(serializerProviderInstance.getGenerator());
    assertNull(serializerProviderInstance2.getGenerator());
    assertNull(serializerProviderInstance3.getGenerator());
    assertNull(serializerProviderInstance4.getGenerator());
    assertNull(deserializationContext.getParser());
    assertNull(deserializationContext2.getParser());
    assertNull(deserializationContext3.getParser());
    assertNull(deserializationContext4.getParser());
    assertNull(factory.getCharacterEscapes());
    assertNull(factory2.getCharacterEscapes());
    assertNull(factory3.getCharacterEscapes());
    assertNull(factory4.getCharacterEscapes());
    assertNull(factory.getInputDecorator());
    assertNull(factory2.getInputDecorator());
    assertNull(factory3.getInputDecorator());
    assertNull(factory4.getInputDecorator());
    assertNull(factory.getOutputDecorator());
    assertNull(factory2.getOutputDecorator());
    assertNull(factory3.getOutputDecorator());
    assertNull(factory4.getOutputDecorator());
    assertNull(deserializationContext.getConfig());
    assertNull(deserializationContext2.getConfig());
    assertNull(deserializationContext3.getConfig());
    assertNull(deserializationContext4.getConfig());
    assertNull(objectMapper2.getInjectableValues());
    assertNull(objectMapper3.getInjectableValues());
    assertNull(objectMapper.getInjectableValues());
    assertNull(objectMapper4.getInjectableValues());
    assertNull(deserializationContext.getContextualType());
    assertNull(deserializationContext2.getContextualType());
    assertNull(deserializationContext3.getContextualType());
    assertNull(deserializationContext4.getContextualType());
    assertNull(defaultNullKeySerializer.getDelegatee());
    assertNull(defaultNullValueSerializer.getDelegatee());
    assertNull(deserializationConfig2.getFullRootName());
    assertNull(deserializationConfig3.getFullRootName());
    assertNull(deserializationConfig.getFullRootName());
    assertNull(deserializationConfig4.getFullRootName());
    SerializationConfig serializationConfig2 = objectMapper2.getSerializationConfig();
    assertNull(serializationConfig2.getFullRootName());
    SerializationConfig serializationConfig3 = objectMapper3.getSerializationConfig();
    assertNull(serializationConfig3.getFullRootName());
    assertNull(serializationConfig.getFullRootName());
    SerializationConfig serializationConfig4 = objectMapper4.getSerializationConfig();
    assertNull(serializationConfig4.getFullRootName());
    assertNull(objectMapper2.getPropertyNamingStrategy());
    assertNull(objectMapper3.getPropertyNamingStrategy());
    assertNull(objectMapper.getPropertyNamingStrategy());
    assertNull(objectMapper4.getPropertyNamingStrategy());
    assertNull(deserializationConfig2.getPropertyNamingStrategy());
    assertNull(deserializationConfig3.getPropertyNamingStrategy());
    assertNull(deserializationConfig.getPropertyNamingStrategy());
    assertNull(deserializationConfig4.getPropertyNamingStrategy());
    assertNull(serializationConfig2.getPropertyNamingStrategy());
    assertNull(serializationConfig3.getPropertyNamingStrategy());
    assertNull(serializationConfig.getPropertyNamingStrategy());
    assertNull(serializationConfig4.getPropertyNamingStrategy());
    assertNull(serializerProvider.getConfig());
    assertNull(serializerProvider2.getConfig());
    assertNull(serializerProvider3.getConfig());
    assertNull(serializerProvider4.getConfig());
    assertNull(deserializationConfig2.getHandlerInstantiator());
    assertNull(deserializationConfig3.getHandlerInstantiator());
    assertNull(deserializationConfig.getHandlerInstantiator());
    assertNull(deserializationConfig4.getHandlerInstantiator());
    assertNull(serializationConfig2.getHandlerInstantiator());
    assertNull(serializationConfig3.getHandlerInstantiator());
    assertNull(serializationConfig.getHandlerInstantiator());
    assertNull(serializationConfig4.getHandlerInstantiator());
    assertNull(serializationConfig2.getFilterProvider());
    assertNull(serializationConfig3.getFilterProvider());
    assertNull(serializationConfig.getFilterProvider());
    assertNull(serializationConfig4.getFilterProvider());
    assertNull(serializerProviderInstance.getFilterProvider());
    assertNull(serializerProviderInstance2.getFilterProvider());
    assertNull(serializerProviderInstance3.getFilterProvider());
    assertNull(serializerProviderInstance4.getFilterProvider());
    assertNull(deserializationConfig2.getProblemHandlers());
    assertNull(deserializationConfig3.getProblemHandlers());
    assertNull(deserializationConfig.getProblemHandlers());
    assertNull(deserializationConfig4.getProblemHandlers());
    assertNull(deserializationConfig2.getDefaultMergeable());
    assertNull(deserializationConfig3.getDefaultMergeable());
    assertNull(deserializationConfig.getDefaultMergeable());
    assertNull(deserializationConfig4.getDefaultMergeable());
    assertNull(serializationConfig2.getDefaultMergeable());
    assertNull(serializationConfig3.getDefaultMergeable());
    assertNull(serializationConfig.getDefaultMergeable());
    assertNull(serializationConfig4.getDefaultMergeable());
    assertNull(factory.getFormatReadFeatureType());
    assertNull(factory2.getFormatReadFeatureType());
    assertNull(factory3.getFormatReadFeatureType());
    assertNull(factory4.getFormatReadFeatureType());
    assertNull(factory.getFormatWriteFeatureType());
    assertNull(factory2.getFormatWriteFeatureType());
    assertNull(factory3.getFormatWriteFeatureType());
    assertNull(factory4.getFormatWriteFeatureType());
    JsonInclude.Value defaultPropertyInclusion = deserializationConfig.getDefaultPropertyInclusion();
    assertNull(defaultPropertyInclusion.getContentFilter());
    assertNull(defaultPropertyInclusion.getValueFilter());
    assertNull(deserializationContext.getActiveView());
    assertNull(deserializationContext2.getActiveView());
    assertNull(deserializationContext3.getActiveView());
    assertNull(deserializationContext4.getActiveView());
    assertNull(serializerProvider.getActiveView());
    assertNull(serializerProvider2.getActiveView());
    assertNull(serializerProvider3.getActiveView());
    assertNull(serializerProvider4.getActiveView());
    assertNull(serializerProviderInstance.getActiveView());
    assertNull(serializerProviderInstance2.getActiveView());
    assertNull(serializerProviderInstance3.getActiveView());
    assertNull(serializerProviderInstance4.getActiveView());
    assertNull(deserializationConfig2.getActiveView());
    assertNull(deserializationConfig3.getActiveView());
    assertNull(deserializationConfig.getActiveView());
    assertNull(deserializationConfig4.getActiveView());
    assertNull(serializationConfig2.getActiveView());
    assertNull(serializationConfig3.getActiveView());
    assertNull(serializationConfig.getActiveView());
    assertNull(serializationConfig4.getActiveView());
    assertNull(objectMapper2.getTypeFactory().getClassLoader());
    assertNull(objectMapper3.getTypeFactory().getClassLoader());
    TypeFactory typeFactory = objectMapper.getTypeFactory();
    assertNull(typeFactory.getClassLoader());
    TypeFactory typeFactory2 = objectMapper4.getTypeFactory();
    assertNull(typeFactory2.getClassLoader());
    assertNull(deserializationConfig2.getRootName());
    assertNull(deserializationConfig3.getRootName());
    assertNull(deserializationConfig.getRootName());
    assertNull(deserializationConfig4.getRootName());
    assertNull(serializationConfig2.getRootName());
    assertNull(serializationConfig3.getRootName());
    assertNull(serializationConfig.getRootName());
    assertNull(serializationConfig4.getRootName());
    assertNull(getResult19.getSubtypeSuffix());
    assertNull(getResult17.getSubtypeSuffix());
    assertNull(getResult25.getSubtypeSuffix());
    assertNull(getResult20.getSubtypeSuffix());
    assertNull(getResult22.getSubtypeSuffix());
    assertNull(getResult23.getSubtypeSuffix());
    assertNull(getResult24.getSubtypeSuffix());
    assertNull(getResult21.getSubtypeSuffix());
    assertNull(actualRestClient.getRefreshToken());
    assertNull(actualRestClient.getToken());
    assertNull(((ByteArrayHttpMessageConverter) getResult7).getDefaultCharset());
    assertNull(((ByteArrayHttpMessageConverter) getResult8).getDefaultCharset());
    assertNull(((ByteArrayHttpMessageConverter) getResult9).getDefaultCharset());
    assertNull(((ByteArrayHttpMessageConverter) getResult10).getDefaultCharset());
    assertNull(((ResourceHttpMessageConverter) getResult11).getDefaultCharset());
    assertNull(((ResourceHttpMessageConverter) getResult12).getDefaultCharset());
    assertNull(((MappingJackson2HttpMessageConverter) getResult3).getDefaultCharset());
    assertNull(((MappingJackson2HttpMessageConverter) getResult5).getDefaultCharset());
    assertNull(((MappingJackson2HttpMessageConverter) getResult).getDefaultCharset());
    assertNull(((MappingJackson2HttpMessageConverter) getResult6).getDefaultCharset());
    assertNull(getResult19.getCharset());
    assertNull(getResult17.getCharset());
    assertNull(getResult25.getCharset());
    assertNull(getResult20.getCharset());
    assertNull(getResult22.getCharset());
    assertNull(getResult23.getCharset());
    assertNull(getResult24.getCharset());
    assertNull(getResult21.getCharset());
    assertNull(getResult18.getCharset());
    assertNull(dateFormat.getNumberFormat());
    assertNull(dateFormat.getCalendar());
    assertNull(dateFormat.getTimeZone());
    assertNull(restTemplate.getObservationConvention());
    assertNull(restTemplate2.getObservationConvention());
    assertEquals(0, factory.getFormatGeneratorFeatures());
    assertEquals(0, factory2.getFormatGeneratorFeatures());
    assertEquals(0, factory3.getFormatGeneratorFeatures());
    assertEquals(0, factory4.getFormatGeneratorFeatures());
    assertEquals(0, factory.getFormatParserFeatures());
    assertEquals(0, factory2.getFormatParserFeatures());
    assertEquals(0, factory3.getFormatParserFeatures());
    assertEquals(0, factory4.getFormatParserFeatures());
    assertEquals(0, deserializationContext.getDeserializationFeatures());
    assertEquals(0, deserializationContext2.getDeserializationFeatures());
    assertEquals(0, deserializationContext3.getDeserializationFeatures());
    assertEquals(0, deserializationContext4.getDeserializationFeatures());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, factory.getParserFeatures());
    assertEquals(1, factory2.getParserFeatures());
    assertEquals(1, factory3.getParserFeatures());
    assertEquals(1, factory4.getParserFeatures());
    assertEquals(1, restTemplate.getInterceptors().size());
    List<MediaType> supportedMediaTypes5 = getResult11.getSupportedMediaTypes();
    assertEquals(1, supportedMediaTypes5.size());
    assertEquals(1.0d, getResult19.getQualityValue());
    assertEquals(1.0d, getResult17.getQualityValue());
    assertEquals(1.0d, getResult25.getQualityValue());
    assertEquals(1.0d, getResult20.getQualityValue());
    assertEquals(1.0d, getResult22.getQualityValue());
    assertEquals(1.0d, getResult23.getQualityValue());
    assertEquals(1.0d, getResult24.getQualityValue());
    assertEquals(1.0d, getResult21.getQualityValue());
    assertEquals(1.0d, getResult18.getQualityValue());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(17, versionResult2.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult2.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(2, versionResult2.getPatchLevel());
    Set<Object> registeredModuleIds = objectMapper.getRegisteredModuleIds();
    assertEquals(2, registeredModuleIds.size());
    assertEquals(2079, factory.getGeneratorFeatures());
    assertEquals(2079, factory2.getGeneratorFeatures());
    assertEquals(2079, factory3.getGeneratorFeatures());
    assertEquals(2079, factory4.getGeneratorFeatures());
    assertEquals(21771068, serializationConfig2.getSerializationFeatures());
    assertEquals(21771068, serializationConfig3.getSerializationFeatures());
    assertEquals(21771068, serializationConfig.getSerializationFeatures());
    assertEquals(21771068, serializationConfig4.getSerializationFeatures());
    assertEquals(31, factory.getFactoryFeatures());
    assertEquals(31, factory2.getFactoryFeatures());
    assertEquals(31, factory3.getFactoryFeatures());
    assertEquals(31, factory4.getFactoryFeatures());
    assertEquals(473998464, deserializationConfig2.getDeserializationFeatures());
    assertEquals(473998464, deserializationConfig3.getDeserializationFeatures());
    assertEquals(473998464, deserializationConfig.getDeserializationFeatures());
    assertEquals(473998464, deserializationConfig4.getDeserializationFeatures());
    JsonNodeFactory nodeFactory = objectMapper.getNodeFactory();
    assertEquals(9999, nodeFactory.getMaxElementIndexForInsert());
    assertEquals(JsonInclude.Include.ALWAYS, serializationConfig2.getSerializationInclusion());
    assertEquals(JsonInclude.Include.ALWAYS, serializationConfig3.getSerializationInclusion());
    assertEquals(JsonInclude.Include.ALWAYS, serializationConfig.getSerializationInclusion());
    assertEquals(JsonInclude.Include.ALWAYS, serializationConfig4.getSerializationInclusion());
    assertEquals(JsonInclude.Include.USE_DEFAULTS, defaultPropertyInclusion.getContentInclusion());
    assertEquals(JsonInclude.Include.USE_DEFAULTS, defaultPropertyInclusion.getValueInclusion());
    JsonSetter.Value defaultSetterInfo = deserializationConfig.getDefaultSetterInfo();
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getContentNulls());
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getValueNulls());
    assertEquals(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT,
        ((DefaultUriBuilderFactory) uriTemplateHandler).getEncodingMode());
    assertEquals(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT,
        ((DefaultUriBuilderFactory) uriTemplateHandler2).getEncodingMode());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult2.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult2.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(versionResult2.isUnknownVersion());
    assertFalse(defaultNullKeySerializer.isUnwrappingSerializer());
    assertFalse(defaultNullValueSerializer.isUnwrappingSerializer());
    assertFalse(factoryConfig.hasAbstractTypeResolvers());
    assertFalse(factoryConfig2.hasAbstractTypeResolvers());
    assertFalse(deserializationConfig2.hasExplicitTimeZone());
    assertFalse(deserializationConfig3.hasExplicitTimeZone());
    assertFalse(deserializationConfig.hasExplicitTimeZone());
    assertFalse(deserializationConfig4.hasExplicitTimeZone());
    assertFalse(serializationConfig2.hasExplicitTimeZone());
    assertFalse(serializationConfig3.hasExplicitTimeZone());
    assertFalse(serializationConfig.hasExplicitTimeZone());
    assertFalse(serializationConfig4.hasExplicitTimeZone());
    assertFalse(locale.hasExtensions());
    assertFalse(getResult17.isConcrete());
    assertFalse(getResult18.isConcrete());
    assertFalse(getResult19.isWildcardType());
    assertFalse(getResult25.isWildcardType());
    assertFalse(getResult20.isWildcardType());
    assertFalse(getResult22.isWildcardType());
    assertFalse(getResult23.isWildcardType());
    assertFalse(getResult24.isWildcardType());
    assertFalse(getResult21.isWildcardType());
    assertFalse(getResult18.isWildcardType());
    assertFalse(((DefaultUriBuilderFactory) uriTemplateHandler).hasBaseUri());
    assertFalse(((DefaultUriBuilderFactory) uriTemplateHandler2).hasBaseUri());
    assertTrue(factoryConfig.hasDeserializerModifiers());
    assertTrue(factoryConfig2.hasDeserializerModifiers());
    assertTrue(factoryConfig.hasDeserializers());
    assertTrue(factoryConfig2.hasDeserializers());
    assertTrue(factoryConfig.hasKeyDeserializers());
    assertTrue(factoryConfig2.hasKeyDeserializers());
    assertTrue(factoryConfig.hasValueInstantiators());
    assertTrue(factoryConfig2.hasValueInstantiators());
    assertTrue(deserializationConfig2.isAnnotationProcessingEnabled());
    assertTrue(deserializationConfig3.isAnnotationProcessingEnabled());
    assertTrue(deserializationConfig.isAnnotationProcessingEnabled());
    assertTrue(deserializationConfig4.isAnnotationProcessingEnabled());
    assertTrue(serializationConfig2.isAnnotationProcessingEnabled());
    assertTrue(serializationConfig3.isAnnotationProcessingEnabled());
    assertTrue(serializationConfig.isAnnotationProcessingEnabled());
    assertTrue(serializationConfig4.isAnnotationProcessingEnabled());
    assertTrue(factoryConfig3.hasKeySerializers());
    assertTrue(factoryConfig4.hasKeySerializers());
    assertTrue(factoryConfig5.hasKeySerializers());
    assertTrue(factoryConfig6.hasKeySerializers());
    assertTrue(factoryConfig3.hasSerializerModifiers());
    assertTrue(factoryConfig4.hasSerializerModifiers());
    assertTrue(factoryConfig5.hasSerializerModifiers());
    assertTrue(factoryConfig6.hasSerializerModifiers());
    assertTrue(factoryConfig3.hasSerializers());
    assertTrue(factoryConfig4.hasSerializers());
    assertTrue(factoryConfig5.hasSerializers());
    assertTrue(factoryConfig6.hasSerializers());
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult).hasNext());
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult2).hasNext());
    assertTrue(((ArrayIterator<Serializers>) serializersResult).hasNext());
    assertTrue(((ArrayIterator<Serializers>) serializersResult2).hasNext());
    assertTrue(((ArrayIterator<Serializers>) serializersResult3).hasNext());
    assertTrue(((ArrayIterator<Serializers>) serializersResult4).hasNext());
    assertTrue(((StdDateFormat) dateFormat).isColonIncludedInTimeZone());
    ObservationRegistry observationRegistry = restTemplate.getObservationRegistry();
    assertTrue(observationRegistry.isNoop());
    assertTrue(dateFormat.isLenient());
    assertTrue(restTemplate.getClientHttpRequestInitializers().isEmpty());
    assertTrue(restTemplate2.getClientHttpRequestInitializers().isEmpty());
    assertTrue(restTemplate2.getInterceptors().isEmpty());
    Map<String, ?> defaultUriVariables = ((DefaultUriBuilderFactory) uriTemplateHandler).getDefaultUriVariables();
    assertTrue(defaultUriVariables.isEmpty());
    Set<Character> extensionKeys = locale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertTrue(getResult19.isConcrete());
    assertTrue(getResult25.isConcrete());
    assertTrue(getResult20.isConcrete());
    assertTrue(getResult22.isConcrete());
    assertTrue(getResult23.isConcrete());
    assertTrue(getResult24.isConcrete());
    assertTrue(getResult21.isConcrete());
    assertTrue(getResult17.isWildcardType());
    assertEquals(registeredModuleIds, objectMapper2.getRegisteredModuleIds());
    assertEquals(registeredModuleIds, objectMapper3.getRegisteredModuleIds());
    assertEquals(registeredModuleIds, objectMapper4.getRegisteredModuleIds());
    assertEquals(supportedMediaTypes5, getResult12.getSupportedMediaTypes());
    assertEquals(supportedMediaTypes2, getResult3.getSupportedMediaTypes());
    assertEquals(supportedMediaTypes2, getResult5.getSupportedMediaTypes());
    assertEquals(supportedMediaTypes2, getResult6.getSupportedMediaTypes());
    assertEquals(Integer.MAX_VALUE, base64Variant.getMaxLineLength());
    assertEquals('=', base64Variant.getPaddingByte());
    assertSame(versionResult, factory.version());
    assertSame(versionResult, factory2.version());
    assertSame(versionResult, factory4.version());
    assertSame(nodeFactory, deserializationConfig2.getNodeFactory());
    assertSame(nodeFactory, deserializationConfig3.getNodeFactory());
    assertSame(nodeFactory, deserializationConfig.getNodeFactory());
    assertSame(nodeFactory, deserializationConfig4.getNodeFactory());
    assertSame(nodeFactory, objectMapper2.getNodeFactory());
    assertSame(nodeFactory, objectMapper3.getNodeFactory());
    assertSame(nodeFactory, objectMapper4.getNodeFactory());
    assertSame(serializationConfig, serializerProviderInstance3.getConfig());
    assertSame(serializationConfig4, serializerProviderInstance4.getConfig());
    assertSame(typeFactory, serializerProviderInstance3.getTypeFactory());
    assertSame(typeFactory, deserializationConfig.getTypeFactory());
    assertSame(typeFactory, serializationConfig.getTypeFactory());
    assertSame(typeFactory2, serializerProviderInstance4.getTypeFactory());
    assertSame(typeFactory2, deserializationConfig4.getTypeFactory());
    assertSame(typeFactory2, serializationConfig4.getTypeFactory());
    assertSame(versionResult2, annotationIntrospector.version());
    assertSame(versionResult2, objectMapper2.version());
    assertSame(versionResult2, objectMapper3.version());
    assertSame(versionResult2, objectMapper4.version());
    assertSame(base64Variant, deserializationConfig2.getBase64Variant());
    assertSame(base64Variant, deserializationConfig3.getBase64Variant());
    assertSame(base64Variant, deserializationConfig4.getBase64Variant());
    assertSame(base64Variant, serializationConfig2.getBase64Variant());
    assertSame(base64Variant, serializationConfig3.getBase64Variant());
    assertSame(base64Variant, serializationConfig.getBase64Variant());
    assertSame(base64Variant, serializationConfig4.getBase64Variant());
    assertSame(locale, serializerProviderInstance.getLocale());
    assertSame(locale, serializerProviderInstance2.getLocale());
    assertSame(locale, serializerProviderInstance3.getLocale());
    assertSame(locale, serializerProviderInstance4.getLocale());
    assertSame(locale, deserializationConfig2.getLocale());
    assertSame(locale, deserializationConfig3.getLocale());
    assertSame(locale, deserializationConfig4.getLocale());
    assertSame(locale, serializationConfig2.getLocale());
    assertSame(locale, serializationConfig3.getLocale());
    assertSame(locale, serializationConfig.getLocale());
    assertSame(locale, serializationConfig4.getLocale());
    assertSame(timeZone, serializerProviderInstance.getTimeZone());
    assertSame(timeZone, serializerProviderInstance2.getTimeZone());
    assertSame(timeZone, serializerProviderInstance3.getTimeZone());
    assertSame(timeZone, serializerProviderInstance4.getTimeZone());
    assertSame(timeZone, deserializationConfig2.getTimeZone());
    assertSame(timeZone, deserializationConfig3.getTimeZone());
    assertSame(timeZone, deserializationConfig4.getTimeZone());
    assertSame(timeZone, serializationConfig2.getTimeZone());
    assertSame(timeZone, serializationConfig3.getTimeZone());
    assertSame(timeZone, serializationConfig.getTimeZone());
    assertSame(timeZone, serializationConfig4.getTimeZone());
    assertSame(defaultPropertyInclusion, deserializationConfig2.getDefaultPropertyInclusion());
    assertSame(defaultPropertyInclusion, deserializationConfig3.getDefaultPropertyInclusion());
    assertSame(defaultPropertyInclusion, deserializationConfig4.getDefaultPropertyInclusion());
    assertSame(defaultPropertyInclusion, serializationConfig2.getDefaultPropertyInclusion());
    assertSame(defaultPropertyInclusion, serializationConfig3.getDefaultPropertyInclusion());
    assertSame(defaultPropertyInclusion, serializationConfig.getDefaultPropertyInclusion());
    assertSame(defaultPropertyInclusion, serializationConfig4.getDefaultPropertyInclusion());
    assertSame(defaultSetterInfo, deserializationConfig2.getDefaultSetterInfo());
    assertSame(defaultSetterInfo, deserializationConfig3.getDefaultSetterInfo());
    assertSame(defaultSetterInfo, deserializationConfig4.getDefaultSetterInfo());
    assertSame(defaultSetterInfo, serializationConfig2.getDefaultSetterInfo());
    assertSame(defaultSetterInfo, serializationConfig3.getDefaultSetterInfo());
    assertSame(defaultSetterInfo, serializationConfig.getDefaultSetterInfo());
    assertSame(defaultSetterInfo, serializationConfig4.getDefaultSetterInfo());
    assertSame(getResult17, supportedMediaTypes5.get(0));
    assertSame(getResult17, supportedMediaTypes4.get(1));
    assertSame(extensionKeys, locale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, locale.getUnicodeLocaleKeys());
    assertSame(defaultCharset2, ((StringHttpMessageConverter) getResult14).getDefaultCharset());
    assertSame(defaultCharset, ((StringHttpMessageConverter) getResult16).getDefaultCharset());
    assertSame(objectMapper, factory3.getCodec());
    assertSame(objectMapper4, factory4.getCodec());
    assertSame(observationRegistry, restTemplate2.getObservationRegistry());
    assertSame(defaultUriVariables, getResult19.getParameters());
    assertSame(defaultUriVariables, getResult17.getParameters());
    assertSame(defaultUriVariables, getResult25.getParameters());
    assertSame(defaultUriVariables, getResult20.getParameters());
    assertSame(defaultUriVariables, getResult22.getParameters());
    assertSame(defaultUriVariables, getResult23.getParameters());
    assertSame(defaultUriVariables, getResult24.getParameters());
    assertSame(defaultUriVariables, getResult21.getParameters());
    assertSame(defaultUriVariables, getResult18.getParameters());
    assertSame(defaultUriVariables, ((DefaultUriBuilderFactory) uriTemplateHandler2).getDefaultUriVariables());
    assertSame(defaultPrettyPrinter, serializationConfig2.getDefaultPrettyPrinter());
    assertSame(defaultPrettyPrinter, serializationConfig3.getDefaultPrettyPrinter());
    assertSame(defaultPrettyPrinter, serializationConfig4.getDefaultPrettyPrinter());
    assertSame(factory3, objectMapper.getJsonFactory());
    assertSame(factory4, objectMapper4.getJsonFactory());
    assertSame(attributes, deserializationConfig2.getAttributes());
    assertSame(attributes, deserializationConfig3.getAttributes());
    assertSame(attributes, deserializationConfig4.getAttributes());
    assertSame(attributes, serializationConfig2.getAttributes());
    assertSame(attributes, serializationConfig3.getAttributes());
    assertSame(attributes, serializationConfig.getAttributes());
    assertSame(attributes, serializationConfig4.getAttributes());
    assertSame(cacheProvider, deserializationConfig2.getCacheProvider());
    assertSame(cacheProvider, deserializationConfig3.getCacheProvider());
    assertSame(cacheProvider, deserializationConfig4.getCacheProvider());
    assertSame(cacheProvider, serializationConfig2.getCacheProvider());
    assertSame(cacheProvider, serializationConfig3.getCacheProvider());
    assertSame(cacheProvider, serializationConfig.getCacheProvider());
    assertSame(cacheProvider, serializationConfig4.getCacheProvider());
    assertSame(classIntrospector, serializationConfig.getClassIntrospector());
    assertSame(classIntrospector2, serializationConfig4.getClassIntrospector());
    assertSame(accessorNaming, deserializationConfig2.getAccessorNaming());
    assertSame(accessorNaming, deserializationConfig3.getAccessorNaming());
    assertSame(accessorNaming, deserializationConfig4.getAccessorNaming());
    assertSame(accessorNaming, serializationConfig2.getAccessorNaming());
    assertSame(accessorNaming, serializationConfig3.getAccessorNaming());
    assertSame(accessorNaming, serializationConfig.getAccessorNaming());
    assertSame(accessorNaming, serializationConfig4.getAccessorNaming());
    assertSame(annotationIntrospector, serializerProviderInstance.getAnnotationIntrospector());
    assertSame(annotationIntrospector, serializerProviderInstance2.getAnnotationIntrospector());
    assertSame(annotationIntrospector, serializerProviderInstance3.getAnnotationIntrospector());
    assertSame(annotationIntrospector, serializerProviderInstance4.getAnnotationIntrospector());
    assertSame(annotationIntrospector, deserializationConfig2.getAnnotationIntrospector());
    assertSame(annotationIntrospector, deserializationConfig3.getAnnotationIntrospector());
    assertSame(annotationIntrospector, deserializationConfig4.getAnnotationIntrospector());
    assertSame(annotationIntrospector, serializationConfig2.getAnnotationIntrospector());
    assertSame(annotationIntrospector, serializationConfig3.getAnnotationIntrospector());
    assertSame(annotationIntrospector, serializationConfig.getAnnotationIntrospector());
    assertSame(annotationIntrospector, serializationConfig4.getAnnotationIntrospector());
    assertSame(visibilityChecker, objectMapper2.getVisibilityChecker());
    assertSame(visibilityChecker, objectMapper3.getVisibilityChecker());
    assertSame(visibilityChecker, objectMapper4.getVisibilityChecker());
    assertSame(visibilityChecker, deserializationConfig2.getDefaultVisibilityChecker());
    assertSame(visibilityChecker, deserializationConfig3.getDefaultVisibilityChecker());
    assertSame(visibilityChecker, deserializationConfig.getDefaultVisibilityChecker());
    assertSame(visibilityChecker, deserializationConfig4.getDefaultVisibilityChecker());
    assertSame(visibilityChecker, serializationConfig2.getDefaultVisibilityChecker());
    assertSame(visibilityChecker, serializationConfig3.getDefaultVisibilityChecker());
    assertSame(visibilityChecker, serializationConfig.getDefaultVisibilityChecker());
    assertSame(visibilityChecker, serializationConfig4.getDefaultVisibilityChecker());
    assertSame(polymorphicTypeValidator, objectMapper2.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, objectMapper3.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, objectMapper4.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, deserializationConfig2.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, deserializationConfig3.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, deserializationConfig.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, deserializationConfig4.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, serializationConfig2.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, serializationConfig3.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, serializationConfig.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, serializationConfig4.getPolymorphicTypeValidator());
    assertSame(subtypeResolver, deserializationConfig.getSubtypeResolver());
    assertSame(subtypeResolver, serializationConfig.getSubtypeResolver());
    assertSame(subtypeResolver2, deserializationConfig4.getSubtypeResolver());
    assertSame(subtypeResolver2, serializationConfig4.getSubtypeResolver());
    assertSame(defaultNullKeySerializer, serializerProvider.getDefaultNullKeySerializer());
    assertSame(defaultNullKeySerializer, serializerProvider2.getDefaultNullKeySerializer());
    assertSame(defaultNullKeySerializer, serializerProvider4.getDefaultNullKeySerializer());
    assertSame(defaultNullKeySerializer, serializerProviderInstance.getDefaultNullKeySerializer());
    assertSame(defaultNullKeySerializer, serializerProviderInstance2.getDefaultNullKeySerializer());
    assertSame(defaultNullKeySerializer, serializerProviderInstance3.getDefaultNullKeySerializer());
    assertSame(defaultNullKeySerializer, serializerProviderInstance4.getDefaultNullKeySerializer());
    assertSame(defaultNullValueSerializer, serializerProvider.getDefaultNullValueSerializer());
    assertSame(defaultNullValueSerializer, serializerProvider2.getDefaultNullValueSerializer());
    assertSame(defaultNullValueSerializer, serializerProvider4.getDefaultNullValueSerializer());
    assertSame(defaultNullValueSerializer, serializerProviderInstance.getDefaultNullValueSerializer());
    assertSame(defaultNullValueSerializer, serializerProviderInstance2.getDefaultNullValueSerializer());
    assertSame(defaultNullValueSerializer, serializerProviderInstance3.getDefaultNullValueSerializer());
    assertSame(defaultNullValueSerializer, serializerProviderInstance4.getDefaultNullValueSerializer());
    assertSame(dateFormat, objectMapper2.getDateFormat());
    assertSame(dateFormat, objectMapper3.getDateFormat());
    assertSame(dateFormat, objectMapper4.getDateFormat());
    assertSame(dateFormat, deserializationConfig2.getDateFormat());
    assertSame(dateFormat, deserializationConfig3.getDateFormat());
    assertSame(dateFormat, deserializationConfig.getDateFormat());
    assertSame(dateFormat, deserializationConfig4.getDateFormat());
    assertSame(dateFormat, serializationConfig2.getDateFormat());
    assertSame(dateFormat, serializationConfig3.getDateFormat());
    assertSame(dateFormat, serializationConfig.getDateFormat());
    assertSame(dateFormat, serializationConfig4.getDateFormat());
    assertSame(requestFactory2, ((InterceptingClientHttpRequestFactory) requestFactory).getDelegate());
  }

  /**
   * Test {@link RestClient#RestClient(RestTemplate, String)}.
   * <ul>
   *   <li>Then return {@link RestClient#loginRestTemplate} MessageConverters size
   * is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestClient#RestClient(RestTemplate, String)}
   */
  @Test
  @DisplayName("Test new RestClient(RestTemplate, String); then return loginRestTemplate MessageConverters size is five")
  void testNewRestClient_thenReturnLoginRestTemplateMessageConvertersSizeIsFive() throws MissingResourceException {
    // Arrange
    RestTemplate restTemplate = mock(RestTemplate.class);
    when(restTemplate.getInterceptors()).thenReturn(new ArrayList<>());
    when(restTemplate.getRequestFactory()).thenReturn(mock(ClientHttpRequestFactory.class));

    // Act
    RestClient actualRestClient = new RestClient(restTemplate, "https://example.org/example");

    // Assert
    verify(restTemplate).getInterceptors();
    verify(restTemplate).getRequestFactory();
    RestTemplate restTemplate2 = actualRestClient.loginRestTemplate;
    List<HttpMessageConverter<?>> messageConverters = restTemplate2.getMessageConverters();
    assertEquals(5, messageConverters.size());
    HttpMessageConverter<?> getResult = messageConverters.get(4);
    ObjectMapper objectMapper = ((MappingJackson2HttpMessageConverter) getResult).getObjectMapper();
    SerializationConfig serializationConfig = objectMapper.getSerializationConfig();
    PrettyPrinter defaultPrettyPrinter = serializationConfig.getDefaultPrettyPrinter();
    assertTrue(defaultPrettyPrinter instanceof DefaultPrettyPrinter);
    HttpMessageConverter<?> getResult2 = messageConverters.get(3);
    List<HttpMessageConverter<?>> partConverters = ((AllEncompassingFormHttpMessageConverter) getResult2)
        .getPartConverters();
    assertEquals(4, partConverters.size());
    HttpMessageConverter<?> getResult3 = partConverters.get(3);
    ObjectMapper objectMapper2 = ((MappingJackson2HttpMessageConverter) getResult3).getObjectMapper();
    JsonFactory factory = objectMapper2.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    JsonFactory factory2 = objectMapper.getFactory();
    assertTrue(factory2 instanceof MappingJsonFactory);
    DeserializationConfig deserializationConfig = objectMapper.getDeserializationConfig();
    ContextAttributes attributes = deserializationConfig.getAttributes();
    assertTrue(attributes instanceof ContextAttributes.Impl);
    CacheProvider cacheProvider = deserializationConfig.getCacheProvider();
    assertTrue(cacheProvider instanceof DefaultCacheProvider);
    DeserializationContext deserializationContext = objectMapper2.getDeserializationContext();
    assertTrue(deserializationContext.getFactory() instanceof BeanDeserializerFactory);
    DeserializationContext deserializationContext2 = objectMapper.getDeserializationContext();
    DeserializerFactory factory3 = deserializationContext2.getFactory();
    assertTrue(factory3 instanceof BeanDeserializerFactory);
    assertTrue(deserializationContext instanceof DefaultDeserializationContext.Impl);
    assertTrue(deserializationContext2 instanceof DefaultDeserializationContext.Impl);
    DeserializationConfig deserializationConfig2 = objectMapper2.getDeserializationConfig();
    assertTrue(deserializationConfig2.getClassIntrospector() instanceof BasicClassIntrospector);
    ClassIntrospector classIntrospector = deserializationConfig.getClassIntrospector();
    assertTrue(classIntrospector instanceof BasicClassIntrospector);
    AccessorNamingStrategy.Provider accessorNaming = deserializationConfig.getAccessorNaming();
    assertTrue(accessorNaming instanceof DefaultAccessorNamingStrategy.Provider);
    AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
    assertTrue(annotationIntrospector instanceof JacksonAnnotationIntrospector);
    VisibilityChecker<?> visibilityChecker = objectMapper.getVisibilityChecker();
    assertTrue(visibilityChecker instanceof VisibilityChecker.Std);
    PolymorphicTypeValidator polymorphicTypeValidator = objectMapper.getPolymorphicTypeValidator();
    assertTrue(polymorphicTypeValidator instanceof LaissezFaireSubTypeValidator);
    assertTrue(objectMapper2.getSubtypeResolver() instanceof StdSubtypeResolver);
    SubtypeResolver subtypeResolver = objectMapper.getSubtypeResolver();
    assertTrue(subtypeResolver instanceof StdSubtypeResolver);
    DeserializerFactoryConfig factoryConfig = ((BeanDeserializerFactory) factory3).getFactoryConfig();
    Iterable<Deserializers> deserializersResult = factoryConfig.deserializers();
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult).next() instanceof SimpleDeserializers);
    SerializerFactory serializerFactory = objectMapper2.getSerializerFactory();
    SerializerFactoryConfig factoryConfig2 = ((BeanSerializerFactory) serializerFactory).getFactoryConfig();
    Iterable<Serializers> serializersResult = factoryConfig2.serializers();
    assertTrue(((ArrayIterator<Serializers>) serializersResult).next() instanceof SimpleSerializers);
    SerializerFactory serializerFactory2 = objectMapper.getSerializerFactory();
    SerializerFactoryConfig factoryConfig3 = ((BeanSerializerFactory) serializerFactory2).getFactoryConfig();
    Iterable<Serializers> serializersResult2 = factoryConfig3.serializers();
    assertTrue(((ArrayIterator<Serializers>) serializersResult2).next() instanceof SimpleSerializers);
    assertTrue(serializerFactory instanceof BeanSerializerFactory);
    assertTrue(serializerFactory2 instanceof BeanSerializerFactory);
    SerializerProvider serializerProvider = objectMapper2.getSerializerProvider();
    assertTrue(serializerProvider instanceof DefaultSerializerProvider.Impl);
    SerializerProvider serializerProvider2 = objectMapper.getSerializerProvider();
    assertTrue(serializerProvider2 instanceof DefaultSerializerProvider.Impl);
    SerializerProvider serializerProviderInstance = objectMapper2.getSerializerProviderInstance();
    assertTrue(serializerProviderInstance instanceof DefaultSerializerProvider.Impl);
    SerializerProvider serializerProviderInstance2 = objectMapper.getSerializerProviderInstance();
    assertTrue(serializerProviderInstance2 instanceof DefaultSerializerProvider.Impl);
    JsonSerializer<Object> defaultNullKeySerializer = serializerProvider2.getDefaultNullKeySerializer();
    assertTrue(defaultNullKeySerializer instanceof FailingSerializer);
    JsonSerializer<Object> defaultNullValueSerializer = serializerProvider2.getDefaultNullValueSerializer();
    assertTrue(defaultNullValueSerializer instanceof NullSerializer);
    assertTrue(deserializersResult instanceof ArrayIterator);
    assertTrue(serializersResult instanceof ArrayIterator);
    assertTrue(serializersResult2 instanceof ArrayIterator);
    DateFormat dateFormat = objectMapper.getDateFormat();
    assertTrue(dateFormat instanceof StdDateFormat);
    HttpMessageConverter<?> getResult4 = partConverters.get(0);
    assertTrue(getResult4 instanceof ByteArrayHttpMessageConverter);
    HttpMessageConverter<?> getResult5 = messageConverters.get(0);
    assertTrue(getResult5 instanceof ByteArrayHttpMessageConverter);
    HttpMessageConverter<?> getResult6 = partConverters.get(2);
    assertTrue(getResult6 instanceof ResourceHttpMessageConverter);
    HttpMessageConverter<?> getResult7 = partConverters.get(1);
    assertTrue(getResult7 instanceof StringHttpMessageConverter);
    HttpMessageConverter<?> getResult8 = messageConverters.get(1);
    assertTrue(getResult8 instanceof StringHttpMessageConverter);
    assertTrue(getResult3 instanceof MappingJackson2HttpMessageConverter);
    assertTrue(getResult instanceof MappingJackson2HttpMessageConverter);
    assertTrue(getResult2 instanceof AllEncompassingFormHttpMessageConverter);
    assertTrue(restTemplate2.getErrorHandler() instanceof DefaultResponseErrorHandler);
    UriTemplateHandler uriTemplateHandler = restTemplate2.getUriTemplateHandler();
    assertTrue(uriTemplateHandler instanceof DefaultUriBuilderFactory);
    assertEquals(" ", factory.getRootValueSeparator());
    assertEquals(" ", factory2.getRootValueSeparator());
    Locale locale = deserializationConfig.getLocale();
    assertEquals("", locale.getDisplayScript());
    assertEquals("", locale.getDisplayVariant());
    assertEquals("", locale.getScript());
    assertEquals("", locale.getVariant());
    List<MediaType> supportedMediaTypes = getResult5.getSupportedMediaTypes();
    assertEquals(2, supportedMediaTypes.size());
    MediaType getResult9 = supportedMediaTypes.get(1);
    assertEquals("*", getResult9.getSubtype());
    assertEquals("*", getResult9.getType());
    List<MediaType> supportedMediaTypes2 = getResult.getSupportedMediaTypes();
    assertEquals(2, supportedMediaTypes2.size());
    MediaType getResult10 = supportedMediaTypes2.get(1);
    assertEquals("*+json", getResult10.getSubtype());
    TimeZone timeZone = deserializationConfig.getTimeZone();
    assertEquals("Coordinated Universal Time", timeZone.getDisplayName());
    assertEquals("English (United Kingdom)", locale.getDisplayName());
    assertEquals("English", locale.getDisplayLanguage());
    assertEquals("GB", locale.getCountry());
    assertEquals("GBR", locale.getISO3Country());
    assertEquals("ISO-8859-1", ((StringHttpMessageConverter) getResult8).getDefaultCharset().name());
    assertEquals("JSON", factory.getFormatName());
    assertEquals("JSON", factory2.getFormatName());
    Base64Variant base64Variant = deserializationConfig.getBase64Variant();
    assertEquals("MIME-NO-LINEFEEDS", base64Variant.getName());
    assertEquals("MIME-NO-LINEFEEDS", base64Variant.toString());
    assertEquals("UTC", timeZone.getID());
    assertEquals("UTF-8", ((StringHttpMessageConverter) getResult7).getDefaultCharset().name());
    assertEquals("United Kingdom", locale.getDisplayCountry());
    assertEquals("[one of: 'yyyy-MM-dd'T'HH:mm:ss.SSSX', 'EEE, dd MMM yyyy HH:mm:ss zzz' (lenient)]",
        ((StdDateFormat) dateFormat).toPattern());
    MediaType getResult11 = supportedMediaTypes.get(0);
    assertEquals("application", getResult11.getType());
    List<MediaType> supportedMediaTypes3 = getResult2.getSupportedMediaTypes();
    assertEquals(4, supportedMediaTypes3.size());
    MediaType getResult12 = supportedMediaTypes3.get(0);
    assertEquals("application", getResult12.getType());
    MediaType getResult13 = supportedMediaTypes2.get(0);
    assertEquals("application", getResult13.getType());
    assertEquals("application", getResult10.getType());
    Version versionResult = factory2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    Version versionResult2 = objectMapper.version();
    assertEquals("com.fasterxml.jackson.core", versionResult2.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-core/2.17.2", versionResult.toFullString());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult2.toFullString());
    assertEquals("en", locale.getLanguage());
    assertEquals("eng", locale.getISO3Language());
    MediaType getResult14 = supportedMediaTypes3.get(1);
    assertEquals("form-data", getResult14.getSubtype());
    assertEquals("https://example.org/example", actualRestClient.baseURL);
    assertEquals("jackson-core", versionResult.getArtifactId());
    assertEquals("jackson-databind", versionResult2.getArtifactId());
    assertEquals("json", getResult13.getSubtype());
    assertEquals("json", getResult10.getSubtypeSuffix());
    MediaType getResult15 = supportedMediaTypes3.get(2);
    assertEquals("mixed", getResult15.getSubtype());
    assertEquals("multipart", getResult14.getType());
    assertEquals("multipart", getResult15.getType());
    MediaType getResult16 = supportedMediaTypes3.get(3);
    assertEquals("multipart", getResult16.getType());
    assertEquals("octet-stream", getResult11.getSubtype());
    List<MediaType> supportedMediaTypes4 = getResult8.getSupportedMediaTypes();
    assertEquals(2, supportedMediaTypes4.size());
    MediaType getResult17 = supportedMediaTypes4.get(0);
    assertEquals("plain", getResult17.getSubtype());
    assertEquals("related", getResult16.getSubtype());
    assertEquals("text", getResult17.getType());
    assertEquals("x-www-form-urlencoded", getResult12.getSubtype());
    assertEquals('=', base64Variant.getPaddingChar());
    assertNull(serializerProvider.getGenerator());
    assertNull(serializerProvider2.getGenerator());
    assertNull(serializerProviderInstance.getGenerator());
    assertNull(serializerProviderInstance2.getGenerator());
    assertNull(deserializationContext.getParser());
    assertNull(deserializationContext2.getParser());
    assertNull(factory.getCharacterEscapes());
    assertNull(factory2.getCharacterEscapes());
    assertNull(factory.getInputDecorator());
    assertNull(factory2.getInputDecorator());
    assertNull(factory.getOutputDecorator());
    assertNull(factory2.getOutputDecorator());
    assertNull(deserializationContext.getConfig());
    assertNull(deserializationContext2.getConfig());
    assertNull(objectMapper2.getInjectableValues());
    assertNull(objectMapper.getInjectableValues());
    assertNull(deserializationContext.getContextualType());
    assertNull(deserializationContext2.getContextualType());
    assertNull(defaultNullKeySerializer.getDelegatee());
    assertNull(defaultNullValueSerializer.getDelegatee());
    assertNull(deserializationConfig2.getFullRootName());
    assertNull(deserializationConfig.getFullRootName());
    SerializationConfig serializationConfig2 = objectMapper2.getSerializationConfig();
    assertNull(serializationConfig2.getFullRootName());
    assertNull(serializationConfig.getFullRootName());
    assertNull(objectMapper2.getPropertyNamingStrategy());
    assertNull(objectMapper.getPropertyNamingStrategy());
    assertNull(deserializationConfig2.getPropertyNamingStrategy());
    assertNull(deserializationConfig.getPropertyNamingStrategy());
    assertNull(serializationConfig2.getPropertyNamingStrategy());
    assertNull(serializationConfig.getPropertyNamingStrategy());
    assertNull(serializerProvider.getConfig());
    assertNull(serializerProvider2.getConfig());
    assertNull(deserializationConfig2.getHandlerInstantiator());
    assertNull(deserializationConfig.getHandlerInstantiator());
    assertNull(serializationConfig2.getHandlerInstantiator());
    assertNull(serializationConfig.getHandlerInstantiator());
    assertNull(serializationConfig2.getFilterProvider());
    assertNull(serializationConfig.getFilterProvider());
    assertNull(serializerProviderInstance.getFilterProvider());
    assertNull(serializerProviderInstance2.getFilterProvider());
    assertNull(deserializationConfig2.getProblemHandlers());
    assertNull(deserializationConfig.getProblemHandlers());
    assertNull(deserializationConfig2.getDefaultMergeable());
    assertNull(deserializationConfig.getDefaultMergeable());
    assertNull(serializationConfig2.getDefaultMergeable());
    assertNull(serializationConfig.getDefaultMergeable());
    assertNull(factory.getFormatReadFeatureType());
    assertNull(factory2.getFormatReadFeatureType());
    assertNull(factory.getFormatWriteFeatureType());
    assertNull(factory2.getFormatWriteFeatureType());
    JsonInclude.Value defaultPropertyInclusion = deserializationConfig.getDefaultPropertyInclusion();
    assertNull(defaultPropertyInclusion.getContentFilter());
    assertNull(defaultPropertyInclusion.getValueFilter());
    assertNull(deserializationContext.getActiveView());
    assertNull(deserializationContext2.getActiveView());
    assertNull(serializerProvider.getActiveView());
    assertNull(serializerProvider2.getActiveView());
    assertNull(serializerProviderInstance.getActiveView());
    assertNull(serializerProviderInstance2.getActiveView());
    assertNull(deserializationConfig2.getActiveView());
    assertNull(deserializationConfig.getActiveView());
    assertNull(serializationConfig2.getActiveView());
    assertNull(serializationConfig.getActiveView());
    assertNull(objectMapper2.getTypeFactory().getClassLoader());
    TypeFactory typeFactory = objectMapper.getTypeFactory();
    assertNull(typeFactory.getClassLoader());
    assertNull(actualRestClient.getMaxDatapointsLimit());
    assertNull(actualRestClient.getServerTime());
    assertNull(deserializationConfig2.getRootName());
    assertNull(deserializationConfig.getRootName());
    assertNull(serializationConfig2.getRootName());
    assertNull(serializationConfig.getRootName());
    assertNull(getResult11.getSubtypeSuffix());
    assertNull(getResult9.getSubtypeSuffix());
    assertNull(getResult17.getSubtypeSuffix());
    assertNull(getResult12.getSubtypeSuffix());
    assertNull(getResult14.getSubtypeSuffix());
    assertNull(getResult15.getSubtypeSuffix());
    assertNull(getResult16.getSubtypeSuffix());
    assertNull(getResult13.getSubtypeSuffix());
    assertNull(actualRestClient.getRefreshToken());
    assertNull(actualRestClient.getToken());
    assertNull(((ByteArrayHttpMessageConverter) getResult4).getDefaultCharset());
    assertNull(((ByteArrayHttpMessageConverter) getResult5).getDefaultCharset());
    assertNull(((ResourceHttpMessageConverter) getResult6).getDefaultCharset());
    assertNull(((MappingJackson2HttpMessageConverter) getResult3).getDefaultCharset());
    assertNull(((MappingJackson2HttpMessageConverter) getResult).getDefaultCharset());
    assertNull(getResult11.getCharset());
    assertNull(getResult9.getCharset());
    assertNull(getResult17.getCharset());
    assertNull(getResult12.getCharset());
    assertNull(getResult14.getCharset());
    assertNull(getResult15.getCharset());
    assertNull(getResult16.getCharset());
    assertNull(getResult13.getCharset());
    assertNull(getResult10.getCharset());
    assertNull(dateFormat.getNumberFormat());
    assertNull(dateFormat.getCalendar());
    assertNull(dateFormat.getTimeZone());
    assertNull(restTemplate2.getObservationConvention());
    assertEquals(0, factory.getFormatGeneratorFeatures());
    assertEquals(0, factory2.getFormatGeneratorFeatures());
    assertEquals(0, factory.getFormatParserFeatures());
    assertEquals(0, factory2.getFormatParserFeatures());
    assertEquals(0, deserializationContext.getDeserializationFeatures());
    assertEquals(0, deserializationContext2.getDeserializationFeatures());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, factory.getParserFeatures());
    assertEquals(1, factory2.getParserFeatures());
    List<MediaType> supportedMediaTypes5 = getResult6.getSupportedMediaTypes();
    assertEquals(1, supportedMediaTypes5.size());
    assertEquals(1.0d, getResult11.getQualityValue());
    assertEquals(1.0d, getResult9.getQualityValue());
    assertEquals(1.0d, getResult17.getQualityValue());
    assertEquals(1.0d, getResult12.getQualityValue());
    assertEquals(1.0d, getResult14.getQualityValue());
    assertEquals(1.0d, getResult15.getQualityValue());
    assertEquals(1.0d, getResult16.getQualityValue());
    assertEquals(1.0d, getResult13.getQualityValue());
    assertEquals(1.0d, getResult10.getQualityValue());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(17, versionResult2.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult2.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(2, versionResult2.getPatchLevel());
    Set<Object> registeredModuleIds = objectMapper.getRegisteredModuleIds();
    assertEquals(2, registeredModuleIds.size());
    assertEquals(2079, factory.getGeneratorFeatures());
    assertEquals(2079, factory2.getGeneratorFeatures());
    assertEquals(21771068, serializationConfig2.getSerializationFeatures());
    assertEquals(21771068, serializationConfig.getSerializationFeatures());
    assertEquals(31, factory.getFactoryFeatures());
    assertEquals(31, factory2.getFactoryFeatures());
    assertEquals(473998464, deserializationConfig2.getDeserializationFeatures());
    assertEquals(473998464, deserializationConfig.getDeserializationFeatures());
    JsonNodeFactory nodeFactory = objectMapper.getNodeFactory();
    assertEquals(9999, nodeFactory.getMaxElementIndexForInsert());
    assertEquals(JsonInclude.Include.ALWAYS, serializationConfig2.getSerializationInclusion());
    assertEquals(JsonInclude.Include.ALWAYS, serializationConfig.getSerializationInclusion());
    assertEquals(JsonInclude.Include.USE_DEFAULTS, defaultPropertyInclusion.getContentInclusion());
    assertEquals(JsonInclude.Include.USE_DEFAULTS, defaultPropertyInclusion.getValueInclusion());
    JsonSetter.Value defaultSetterInfo = deserializationConfig.getDefaultSetterInfo();
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getContentNulls());
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getValueNulls());
    assertEquals(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT,
        ((DefaultUriBuilderFactory) uriTemplateHandler).getEncodingMode());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult2.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult2.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(versionResult2.isUnknownVersion());
    assertFalse(defaultNullKeySerializer.isUnwrappingSerializer());
    assertFalse(defaultNullValueSerializer.isUnwrappingSerializer());
    assertFalse(factoryConfig.hasAbstractTypeResolvers());
    assertFalse(deserializationConfig2.hasExplicitTimeZone());
    assertFalse(deserializationConfig.hasExplicitTimeZone());
    assertFalse(serializationConfig2.hasExplicitTimeZone());
    assertFalse(serializationConfig.hasExplicitTimeZone());
    assertFalse(locale.hasExtensions());
    assertFalse(getResult9.isConcrete());
    assertFalse(getResult10.isConcrete());
    assertFalse(getResult11.isWildcardType());
    assertFalse(getResult17.isWildcardType());
    assertFalse(getResult12.isWildcardType());
    assertFalse(getResult14.isWildcardType());
    assertFalse(getResult15.isWildcardType());
    assertFalse(getResult16.isWildcardType());
    assertFalse(getResult13.isWildcardType());
    assertFalse(getResult10.isWildcardType());
    assertFalse(((DefaultUriBuilderFactory) uriTemplateHandler).hasBaseUri());
    assertTrue(factoryConfig.hasDeserializerModifiers());
    assertTrue(factoryConfig.hasDeserializers());
    assertTrue(factoryConfig.hasKeyDeserializers());
    assertTrue(factoryConfig.hasValueInstantiators());
    assertTrue(deserializationConfig2.isAnnotationProcessingEnabled());
    assertTrue(deserializationConfig.isAnnotationProcessingEnabled());
    assertTrue(serializationConfig2.isAnnotationProcessingEnabled());
    assertTrue(serializationConfig.isAnnotationProcessingEnabled());
    assertTrue(factoryConfig2.hasKeySerializers());
    assertTrue(factoryConfig3.hasKeySerializers());
    assertTrue(factoryConfig2.hasSerializerModifiers());
    assertTrue(factoryConfig3.hasSerializerModifiers());
    assertTrue(factoryConfig2.hasSerializers());
    assertTrue(factoryConfig3.hasSerializers());
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult).hasNext());
    assertTrue(((ArrayIterator<Serializers>) serializersResult).hasNext());
    assertTrue(((ArrayIterator<Serializers>) serializersResult2).hasNext());
    assertTrue(((StdDateFormat) dateFormat).isColonIncludedInTimeZone());
    assertTrue(restTemplate2.getObservationRegistry().isNoop());
    assertTrue(dateFormat.isLenient());
    assertTrue(restTemplate2.getClientHttpRequestInitializers().isEmpty());
    assertTrue(restTemplate2.getInterceptors().isEmpty());
    Map<String, ?> defaultUriVariables = ((DefaultUriBuilderFactory) uriTemplateHandler).getDefaultUriVariables();
    assertTrue(defaultUriVariables.isEmpty());
    Set<Character> extensionKeys = locale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertTrue(getResult11.isConcrete());
    assertTrue(getResult17.isConcrete());
    assertTrue(getResult12.isConcrete());
    assertTrue(getResult14.isConcrete());
    assertTrue(getResult15.isConcrete());
    assertTrue(getResult16.isConcrete());
    assertTrue(getResult13.isConcrete());
    assertTrue(getResult9.isWildcardType());
    assertEquals(registeredModuleIds, objectMapper2.getRegisteredModuleIds());
    assertEquals(supportedMediaTypes2, getResult3.getSupportedMediaTypes());
    assertEquals(Integer.MAX_VALUE, base64Variant.getMaxLineLength());
    assertEquals('=', base64Variant.getPaddingByte());
    assertSame(versionResult, factory.version());
    assertSame(nodeFactory, deserializationConfig2.getNodeFactory());
    assertSame(nodeFactory, deserializationConfig.getNodeFactory());
    assertSame(nodeFactory, objectMapper2.getNodeFactory());
    assertSame(serializationConfig, serializerProviderInstance2.getConfig());
    assertSame(typeFactory, serializerProviderInstance2.getTypeFactory());
    assertSame(typeFactory, deserializationConfig.getTypeFactory());
    assertSame(typeFactory, serializationConfig.getTypeFactory());
    assertSame(versionResult2, annotationIntrospector.version());
    assertSame(versionResult2, objectMapper2.version());
    assertSame(base64Variant, deserializationConfig2.getBase64Variant());
    assertSame(base64Variant, serializationConfig2.getBase64Variant());
    assertSame(base64Variant, serializationConfig.getBase64Variant());
    assertSame(locale, serializerProviderInstance.getLocale());
    assertSame(locale, serializerProviderInstance2.getLocale());
    assertSame(locale, deserializationConfig2.getLocale());
    assertSame(locale, serializationConfig2.getLocale());
    assertSame(locale, serializationConfig.getLocale());
    assertSame(timeZone, serializerProviderInstance.getTimeZone());
    assertSame(timeZone, serializerProviderInstance2.getTimeZone());
    assertSame(timeZone, deserializationConfig2.getTimeZone());
    assertSame(timeZone, serializationConfig2.getTimeZone());
    assertSame(timeZone, serializationConfig.getTimeZone());
    assertSame(defaultPropertyInclusion, deserializationConfig2.getDefaultPropertyInclusion());
    assertSame(defaultPropertyInclusion, serializationConfig2.getDefaultPropertyInclusion());
    assertSame(defaultPropertyInclusion, serializationConfig.getDefaultPropertyInclusion());
    assertSame(defaultSetterInfo, deserializationConfig2.getDefaultSetterInfo());
    assertSame(defaultSetterInfo, serializationConfig2.getDefaultSetterInfo());
    assertSame(defaultSetterInfo, serializationConfig.getDefaultSetterInfo());
    assertSame(getResult9, supportedMediaTypes5.get(0));
    assertSame(getResult9, supportedMediaTypes4.get(1));
    assertSame(extensionKeys, locale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, locale.getUnicodeLocaleKeys());
    assertSame(objectMapper, factory2.getCodec());
    assertSame(defaultUriVariables, getResult11.getParameters());
    assertSame(defaultUriVariables, getResult9.getParameters());
    assertSame(defaultUriVariables, getResult17.getParameters());
    assertSame(defaultUriVariables, getResult12.getParameters());
    assertSame(defaultUriVariables, getResult14.getParameters());
    assertSame(defaultUriVariables, getResult15.getParameters());
    assertSame(defaultUriVariables, getResult16.getParameters());
    assertSame(defaultUriVariables, getResult13.getParameters());
    assertSame(defaultUriVariables, getResult10.getParameters());
    assertSame(restTemplate, actualRestClient.getRestTemplate());
    assertSame(defaultPrettyPrinter, serializationConfig2.getDefaultPrettyPrinter());
    assertSame(factory2, objectMapper.getJsonFactory());
    assertSame(attributes, deserializationConfig2.getAttributes());
    assertSame(attributes, serializationConfig2.getAttributes());
    assertSame(attributes, serializationConfig.getAttributes());
    assertSame(cacheProvider, deserializationConfig2.getCacheProvider());
    assertSame(cacheProvider, serializationConfig2.getCacheProvider());
    assertSame(cacheProvider, serializationConfig.getCacheProvider());
    assertSame(classIntrospector, serializationConfig.getClassIntrospector());
    assertSame(accessorNaming, deserializationConfig2.getAccessorNaming());
    assertSame(accessorNaming, serializationConfig2.getAccessorNaming());
    assertSame(accessorNaming, serializationConfig.getAccessorNaming());
    assertSame(annotationIntrospector, serializerProviderInstance.getAnnotationIntrospector());
    assertSame(annotationIntrospector, serializerProviderInstance2.getAnnotationIntrospector());
    assertSame(annotationIntrospector, deserializationConfig2.getAnnotationIntrospector());
    assertSame(annotationIntrospector, serializationConfig2.getAnnotationIntrospector());
    assertSame(annotationIntrospector, serializationConfig.getAnnotationIntrospector());
    assertSame(visibilityChecker, objectMapper2.getVisibilityChecker());
    assertSame(visibilityChecker, deserializationConfig2.getDefaultVisibilityChecker());
    assertSame(visibilityChecker, deserializationConfig.getDefaultVisibilityChecker());
    assertSame(visibilityChecker, serializationConfig2.getDefaultVisibilityChecker());
    assertSame(visibilityChecker, serializationConfig.getDefaultVisibilityChecker());
    assertSame(polymorphicTypeValidator, objectMapper2.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, deserializationConfig2.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, deserializationConfig.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, serializationConfig2.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, serializationConfig.getPolymorphicTypeValidator());
    assertSame(subtypeResolver, deserializationConfig.getSubtypeResolver());
    assertSame(subtypeResolver, serializationConfig.getSubtypeResolver());
    assertSame(defaultNullKeySerializer, serializerProvider.getDefaultNullKeySerializer());
    assertSame(defaultNullKeySerializer, serializerProviderInstance.getDefaultNullKeySerializer());
    assertSame(defaultNullKeySerializer, serializerProviderInstance2.getDefaultNullKeySerializer());
    assertSame(defaultNullValueSerializer, serializerProvider.getDefaultNullValueSerializer());
    assertSame(defaultNullValueSerializer, serializerProviderInstance.getDefaultNullValueSerializer());
    assertSame(defaultNullValueSerializer, serializerProviderInstance2.getDefaultNullValueSerializer());
    assertSame(dateFormat, objectMapper2.getDateFormat());
    assertSame(dateFormat, deserializationConfig2.getDateFormat());
    assertSame(dateFormat, deserializationConfig.getDateFormat());
    assertSame(dateFormat, serializationConfig2.getDateFormat());
    assertSame(dateFormat, serializationConfig.getDateFormat());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RestClient#getRefreshToken()}
   *   <li>{@link RestClient#getRestTemplate()}
   *   <li>{@link RestClient#getToken()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    RestClient restClient = new RestClient("https://example.org/example");

    // Act
    String actualRefreshToken = restClient.getRefreshToken();
    RestTemplate actualRestTemplate = restClient.getRestTemplate();

    // Assert
    assertNull(actualRefreshToken);
    assertNull(restClient.getToken());
    assertSame(restClient.restTemplate, actualRestTemplate);
  }

  /**
   * Test {@link RestClient#findByQuery(EntityRelationsQuery)} with
   * {@code EntityRelationsQuery}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestClient#findByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EntityRelationsQuery) with 'EntityRelationsQuery'; then return 'null'")
  void testFindByQueryWithEntityRelationsQuery_thenReturnNull() throws RestClientException {
    // Arrange
    RestTemplate restTemplate = mock(RestTemplate.class);
    when(restTemplate.exchange(Mockito.<String>any(), Mockito.<HttpMethod>any(), Mockito.<HttpEntity<Object>>any(),
        Mockito.<ParameterizedTypeReference<Object>>any(), isA(Object[].class)))
        .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));
    when(restTemplate.getInterceptors()).thenReturn(new ArrayList<>());
    when(restTemplate.getRequestFactory()).thenReturn(mock(ClientHttpRequestFactory.class));
    RestClient restClient = new RestClient(restTemplate, "https://example.org/example");
    EntityRelationsQuery query = mock(EntityRelationsQuery.class);
    doNothing().when(query).setParameters(Mockito.<RelationsSearchParameters>any());
    doNothing().when(query).setFilters(Mockito.<List<RelationEntityTypeFilter>>any());
    query.setFilters(new ArrayList<>());
    query.setParameters(
        new RelationsSearchParameters(new AlarmId(UUID.randomUUID()), EntitySearchDirection.FROM, 3, true));

    // Act
    List<EntityRelation> actualFindByQueryResult = restClient.findByQuery(query);

    // Assert
    verify(restTemplate).getInterceptors();
    verify(restTemplate).getRequestFactory();
    verify(restTemplate).exchange(eq("https://example.org/example/api/relations"), isA(HttpMethod.class),
        isA(HttpEntity.class), isA(ParameterizedTypeReference.class), isA(Object[].class));
    verify(query).setFilters(isA(List.class));
    verify(query).setParameters(isA(RelationsSearchParameters.class));
    assertNull(actualFindByQueryResult);
  }

  /**
   * Test {@link RestClient#findByQuery(EntityRelationsQuery)} with
   * {@code EntityRelationsQuery}.
   * <ul>
   *   <li>Then throw {@link HttpClientErrorException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestClient#findByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EntityRelationsQuery) with 'EntityRelationsQuery'; then throw HttpClientErrorException")
  void testFindByQueryWithEntityRelationsQuery_thenThrowHttpClientErrorException() throws RestClientException {
    // Arrange
    RestTemplate restTemplate = mock(RestTemplate.class);
    when(restTemplate.exchange(Mockito.<String>any(), Mockito.<HttpMethod>any(), Mockito.<HttpEntity<Object>>any(),
        Mockito.<ParameterizedTypeReference<Object>>any(), isA(Object[].class)))
        .thenThrow(new HttpClientErrorException(HttpStatusCode.valueOf(200)));
    when(restTemplate.getInterceptors()).thenReturn(new ArrayList<>());
    when(restTemplate.getRequestFactory()).thenReturn(mock(ClientHttpRequestFactory.class));
    RestClient restClient = new RestClient(restTemplate, "https://example.org/example");
    EntityRelationsQuery query = mock(EntityRelationsQuery.class);
    doNothing().when(query).setParameters(Mockito.<RelationsSearchParameters>any());
    doNothing().when(query).setFilters(Mockito.<List<RelationEntityTypeFilter>>any());
    query.setFilters(new ArrayList<>());
    query.setParameters(
        new RelationsSearchParameters(new AlarmId(UUID.randomUUID()), EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertThrows(HttpClientErrorException.class, () -> restClient.findByQuery(query));
    verify(restTemplate).getInterceptors();
    verify(restTemplate).getRequestFactory();
    verify(restTemplate).exchange(eq("https://example.org/example/api/relations"), isA(HttpMethod.class),
        isA(HttpEntity.class), isA(ParameterizedTypeReference.class), isA(Object[].class));
    verify(query).setFilters(isA(List.class));
    verify(query).setParameters(isA(RelationsSearchParameters.class));
  }

  /**
   * Test {@link RestClient#findInfoByQuery(EntityRelationsQuery)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestClient#findInfoByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName("Test findInfoByQuery(EntityRelationsQuery); then return 'null'")
  void testFindInfoByQuery_thenReturnNull() throws RestClientException {
    // Arrange
    RestTemplate restTemplate = mock(RestTemplate.class);
    when(restTemplate.exchange(Mockito.<String>any(), Mockito.<HttpMethod>any(), Mockito.<HttpEntity<Object>>any(),
        Mockito.<ParameterizedTypeReference<Object>>any(), isA(Object[].class)))
        .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));
    when(restTemplate.getInterceptors()).thenReturn(new ArrayList<>());
    when(restTemplate.getRequestFactory()).thenReturn(mock(ClientHttpRequestFactory.class));
    RestClient restClient = new RestClient(restTemplate, "https://example.org/example");
    EntityRelationsQuery query = mock(EntityRelationsQuery.class);
    doNothing().when(query).setParameters(Mockito.<RelationsSearchParameters>any());
    doNothing().when(query).setFilters(Mockito.<List<RelationEntityTypeFilter>>any());
    query.setFilters(new ArrayList<>());
    query.setParameters(
        new RelationsSearchParameters(new AlarmId(UUID.randomUUID()), EntitySearchDirection.FROM, 3, true));

    // Act
    List<EntityRelationInfo> actualFindInfoByQueryResult = restClient.findInfoByQuery(query);

    // Assert
    verify(restTemplate).getInterceptors();
    verify(restTemplate).getRequestFactory();
    verify(restTemplate).exchange(eq("https://example.org/example/api/relations/info"), isA(HttpMethod.class),
        isA(HttpEntity.class), isA(ParameterizedTypeReference.class), isA(Object[].class));
    verify(query).setFilters(isA(List.class));
    verify(query).setParameters(isA(RelationsSearchParameters.class));
    assertNull(actualFindInfoByQueryResult);
  }

  /**
   * Test {@link RestClient#findInfoByQuery(EntityRelationsQuery)}.
   * <ul>
   *   <li>Then throw {@link HttpClientErrorException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestClient#findInfoByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName("Test findInfoByQuery(EntityRelationsQuery); then throw HttpClientErrorException")
  void testFindInfoByQuery_thenThrowHttpClientErrorException() throws RestClientException {
    // Arrange
    RestTemplate restTemplate = mock(RestTemplate.class);
    when(restTemplate.exchange(Mockito.<String>any(), Mockito.<HttpMethod>any(), Mockito.<HttpEntity<Object>>any(),
        Mockito.<ParameterizedTypeReference<Object>>any(), isA(Object[].class)))
        .thenThrow(new HttpClientErrorException(HttpStatusCode.valueOf(200)));
    when(restTemplate.getInterceptors()).thenReturn(new ArrayList<>());
    when(restTemplate.getRequestFactory()).thenReturn(mock(ClientHttpRequestFactory.class));
    RestClient restClient = new RestClient(restTemplate, "https://example.org/example");
    EntityRelationsQuery query = mock(EntityRelationsQuery.class);
    doNothing().when(query).setParameters(Mockito.<RelationsSearchParameters>any());
    doNothing().when(query).setFilters(Mockito.<List<RelationEntityTypeFilter>>any());
    query.setFilters(new ArrayList<>());
    query.setParameters(
        new RelationsSearchParameters(new AlarmId(UUID.randomUUID()), EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertThrows(HttpClientErrorException.class, () -> restClient.findInfoByQuery(query));
    verify(restTemplate).getInterceptors();
    verify(restTemplate).getRequestFactory();
    verify(restTemplate).exchange(eq("https://example.org/example/api/relations/info"), isA(HttpMethod.class),
        isA(HttpEntity.class), isA(ParameterizedTypeReference.class), isA(Object[].class));
    verify(query).setFilters(isA(List.class));
    verify(query).setParameters(isA(RelationsSearchParameters.class));
  }

  /**
   * Test {@link RestClient#close()}.
   * <ul>
   *   <li>Then calls {@link InterceptingHttpAccessor#getInterceptors()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestClient#close()}
   */
  @Test
  @DisplayName("Test close(); then calls getInterceptors()")
  void testClose_thenCallsGetInterceptors() {
    // Arrange
    RestTemplate restTemplate = mock(RestTemplate.class);
    when(restTemplate.getInterceptors()).thenReturn(new ArrayList<>());
    when(restTemplate.getRequestFactory()).thenReturn(mock(ClientHttpRequestFactory.class));

    // Act
    (new RestClient(restTemplate, "https://example.org/example")).close();

    // Assert that nothing has changed
    verify(restTemplate).getInterceptors();
    verify(restTemplate).getRequestFactory();
  }
}
