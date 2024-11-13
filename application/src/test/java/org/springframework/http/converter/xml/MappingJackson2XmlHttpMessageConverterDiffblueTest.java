package org.springframework.http.converter.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.ctc.wstx.api.ReaderConfig;
import com.ctc.wstx.api.WriterConfig;
import com.ctc.wstx.stax.WstxInputFactory;
import com.ctc.wstx.stax.WstxOutputFactory;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.CacheProvider;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.cfg.DefaultCacheProvider;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlDeserializationContext;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Serializers;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TimeZone;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import org.aspectj.internal.lang.reflect.AjTypeImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {MappingJackson2XmlHttpMessageConverter.class})
@ExtendWith(SpringExtension.class)
class MappingJackson2XmlHttpMessageConverterDiffblueTest {
  @Autowired
  private MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter;

  /**
   * Test
   * {@link MappingJackson2XmlHttpMessageConverter#MappingJackson2XmlHttpMessageConverter()}.
   * <p>
   * Method under test:
   * {@link MappingJackson2XmlHttpMessageConverter#MappingJackson2XmlHttpMessageConverter()}
   */
  @Test
  @DisplayName("Test new MappingJackson2XmlHttpMessageConverter()")
  void testNewMappingJackson2XmlHttpMessageConverter() throws MissingResourceException {
    // Arrange and Act
    MappingJackson2XmlHttpMessageConverter actualMappingJackson2XmlHttpMessageConverter = new MappingJackson2XmlHttpMessageConverter();

    // Assert
    ObjectMapper objectMapper = actualMappingJackson2XmlHttpMessageConverter.getObjectMapper();
    JsonFactory factory = objectMapper.getFactory();
    XMLInputFactory xMLInputFactory = ((XmlFactory) factory).getXMLInputFactory();
    assertTrue(xMLInputFactory instanceof WstxInputFactory);
    XMLOutputFactory xMLOutputFactory = ((XmlFactory) factory).getXMLOutputFactory();
    assertTrue(xMLOutputFactory instanceof WstxOutputFactory);
    DeserializationConfig deserializationConfig = objectMapper.getDeserializationConfig();
    ContextAttributes attributes = deserializationConfig.getAttributes();
    assertTrue(attributes instanceof ContextAttributes.Impl);
    CacheProvider cacheProvider = deserializationConfig.getCacheProvider();
    assertTrue(cacheProvider instanceof DefaultCacheProvider);
    DeserializationContext deserializationContext = objectMapper.getDeserializationContext();
    DeserializerFactory factory2 = deserializationContext.getFactory();
    assertTrue(factory2 instanceof BeanDeserializerFactory);
    AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
    assertTrue(annotationIntrospector instanceof AnnotationIntrospectorPair);
    SerializationConfig serializationConfig = objectMapper.getSerializationConfig();
    AnnotationIntrospector annotationIntrospector2 = serializationConfig.getAnnotationIntrospector();
    assertTrue(annotationIntrospector2 instanceof AnnotationIntrospectorPair);
    ClassIntrospector classIntrospector = deserializationConfig.getClassIntrospector();
    assertTrue(classIntrospector instanceof BasicClassIntrospector);
    AccessorNamingStrategy.Provider accessorNaming = deserializationConfig.getAccessorNaming();
    assertTrue(accessorNaming instanceof DefaultAccessorNamingStrategy.Provider);
    VisibilityChecker<?> visibilityChecker = objectMapper.getVisibilityChecker();
    assertTrue(visibilityChecker instanceof VisibilityChecker.Std);
    PolymorphicTypeValidator polymorphicTypeValidator = objectMapper.getPolymorphicTypeValidator();
    assertTrue(polymorphicTypeValidator instanceof LaissezFaireSubTypeValidator);
    SubtypeResolver subtypeResolver = objectMapper.getSubtypeResolver();
    assertTrue(subtypeResolver instanceof StdSubtypeResolver);
    DeserializerFactoryConfig factoryConfig = ((BeanDeserializerFactory) factory2).getFactoryConfig();
    Iterable<Deserializers> deserializersResult = factoryConfig.deserializers();
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult).next() instanceof SimpleDeserializers);
    SerializerFactory serializerFactory = objectMapper.getSerializerFactory();
    SerializerFactoryConfig factoryConfig2 = ((BeanSerializerFactory) serializerFactory).getFactoryConfig();
    Iterable<Serializers> serializersResult = factoryConfig2.serializers();
    assertTrue(((ArrayIterator<Serializers>) serializersResult).next() instanceof SimpleSerializers);
    assertTrue(serializerFactory instanceof BeanSerializerFactory);
    SerializerProvider serializerProvider = objectMapper.getSerializerProvider();
    JsonSerializer<Object> defaultNullKeySerializer = serializerProvider.getDefaultNullKeySerializer();
    assertTrue(defaultNullKeySerializer instanceof FailingSerializer);
    JsonSerializer<Object> defaultNullValueSerializer = serializerProvider.getDefaultNullValueSerializer();
    assertTrue(defaultNullValueSerializer instanceof NullSerializer);
    assertTrue(deserializersResult instanceof ArrayIterator);
    assertTrue(serializersResult instanceof ArrayIterator);
    DateFormat dateFormat = objectMapper.getDateFormat();
    assertTrue(dateFormat instanceof StdDateFormat);
    assertTrue(objectMapper instanceof XmlMapper);
    assertTrue(deserializationContext instanceof XmlDeserializationContext);
    assertTrue(serializerProvider instanceof XmlSerializerProvider);
    SerializerProvider serializerProviderInstance = objectMapper.getSerializerProviderInstance();
    assertTrue(serializerProviderInstance instanceof XmlSerializerProvider);
    assertTrue(serializationConfig.getDefaultPrettyPrinter() instanceof DefaultXmlPrettyPrinter);
    assertTrue(((ArrayIterator<Serializers>) serializersResult).next() instanceof Jdk8Serializers);
    assertEquals(" ", factory.getRootValueSeparator());
    Version versionResult = annotationIntrospector.version();
    assertEquals("", versionResult.getArtifactId());
    assertEquals("", versionResult.getGroupId());
    Locale locale = deserializationConfig.getLocale();
    assertEquals("", locale.getDisplayScript());
    assertEquals("", locale.getDisplayVariant());
    assertEquals("", locale.getScript());
    assertEquals("", locale.getVariant());
    List<MediaType> supportedMediaTypes = actualMappingJackson2XmlHttpMessageConverter.getSupportedMediaTypes();
    assertEquals(3, supportedMediaTypes.size());
    MediaType getResult = supportedMediaTypes.get(2);
    assertEquals("*+xml", getResult.getSubtype());
    assertEquals("//0.0.0", versionResult.toFullString());
    TimeZone timeZone = deserializationConfig.getTimeZone();
    assertEquals("Coordinated Universal Time", timeZone.getDisplayName());
    assertEquals("English (United Kingdom)", locale.getDisplayName());
    assertEquals("English", locale.getDisplayLanguage());
    assertEquals("GB", locale.getCountry());
    assertEquals("GBR", locale.getISO3Country());
    Base64Variant base64Variant = deserializationConfig.getBase64Variant();
    assertEquals("MIME", base64Variant.getName());
    assertEquals("MIME", base64Variant.toString());
    assertEquals("UTC", timeZone.getID());
    MediaType getResult2 = supportedMediaTypes.get(0);
    Charset charset = getResult2.getCharset();
    assertEquals("UTF-8", charset.name());
    Map<String, String> parameters = getResult2.getParameters();
    assertEquals(1, parameters.size());
    assertEquals("UTF-8", parameters.get("charset"));
    MediaType getResult3 = supportedMediaTypes.get(1);
    Map<String, String> parameters2 = getResult3.getParameters();
    assertEquals(1, parameters2.size());
    assertEquals("UTF-8", parameters2.get("charset"));
    Map<String, String> parameters3 = getResult.getParameters();
    assertEquals(1, parameters3.size());
    assertEquals("UTF-8", parameters3.get("charset"));
    assertEquals("United Kingdom", locale.getDisplayCountry());
    assertEquals("XML", factory.getFormatName());
    assertEquals("[one of: 'yyyy-MM-dd'T'HH:mm:ss.SSSX', 'EEE, dd MMM yyyy HH:mm:ss zzz' (lenient)]",
        ((StdDateFormat) dateFormat).toPattern());
    assertEquals("application", getResult2.getType());
    assertEquals("application", getResult.getType());
    List<MediaType> mediaTypesForProblemDetail = actualMappingJackson2XmlHttpMessageConverter
        .getMediaTypesForProblemDetail();
    assertEquals(1, mediaTypesForProblemDetail.size());
    MediaType getResult4 = mediaTypesForProblemDetail.get(0);
    assertEquals("application", getResult4.getType());
    Version versionResult2 = objectMapper.version();
    assertEquals("com.fasterxml.jackson.dataformat", versionResult2.getGroupId());
    assertEquals("com.fasterxml.jackson.dataformat/jackson-dataformat-xml/2.14.0", versionResult2.toFullString());
    assertEquals("en", locale.getLanguage());
    assertEquals("eng", locale.getISO3Language());
    assertEquals("jackson-dataformat-xml", versionResult2.getArtifactId());
    assertEquals("problem+xml", getResult4.getSubtype());
    assertEquals("text", getResult3.getType());
    WriterConfig config = ((WstxOutputFactory) xMLOutputFactory).getConfig();
    assertEquals("wstxns", config.getAutomaticNsPrefix());
    assertEquals("xml", getResult2.getSubtype());
    assertEquals("xml", getResult3.getSubtype());
    assertEquals("xml", getResult.getSubtypeSuffix());
    assertEquals("xml", getResult4.getSubtypeSuffix());
    assertEquals('=', base64Variant.getPaddingChar());
    assertNull(config.getEmptyElementHandler());
    assertNull(config.getInvalidCharHandler());
    ReaderConfig config2 = ((WstxInputFactory) xMLInputFactory).getConfig();
    assertNull(config2.getDTDEventListener());
    assertNull(config2.getSymbols());
    assertNull(serializerProvider.getGenerator());
    assertNull(serializerProviderInstance.getGenerator());
    assertNull(deserializationContext.getParser());
    assertNull(factory.getCharacterEscapes());
    assertNull(factory.getInputDecorator());
    assertNull(factory.getOutputDecorator());
    assertNull(deserializationContext.getConfig());
    assertNull(objectMapper.getInjectableValues());
    assertNull(deserializationContext.getContextualType());
    assertNull(defaultNullKeySerializer.getDelegatee());
    assertNull(defaultNullValueSerializer.getDelegatee());
    assertNull(deserializationConfig.getFullRootName());
    assertNull(serializationConfig.getFullRootName());
    assertNull(objectMapper.getPropertyNamingStrategy());
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
    JsonInclude.Value defaultPropertyInclusion = deserializationConfig.getDefaultPropertyInclusion();
    assertNull(defaultPropertyInclusion.getContentFilter());
    assertNull(defaultPropertyInclusion.getValueFilter());
    assertNull(deserializationContext.getActiveView());
    assertNull(serializerProvider.getActiveView());
    assertNull(serializerProviderInstance.getActiveView());
    assertNull(deserializationConfig.getActiveView());
    assertNull(serializationConfig.getActiveView());
    TypeFactory typeFactory = objectMapper.getTypeFactory();
    assertNull(typeFactory.getClassLoader());
    assertNull(deserializationConfig.getRootName());
    assertNull(serializationConfig.getRootName());
    assertNull(((XmlFactory) factory).getXMLTextElementName());
    assertNull(getResult2.getSubtypeSuffix());
    assertNull(getResult3.getSubtypeSuffix());
    assertNull(config2.getBaseURL());
    assertNull(actualMappingJackson2XmlHttpMessageConverter.getDefaultCharset());
    assertNull(getResult4.getCharset());
    assertNull(dateFormat.getNumberFormat());
    assertNull(dateFormat.getCalendar());
    assertNull(dateFormat.getTimeZone());
    assertNull(config2.getXMLReporter());
    assertNull(config.getProblemReporter());
    assertNull(xMLInputFactory.getXMLReporter());
    assertNull(config2.getUndeclaredEntityResolver());
    assertNull(xMLInputFactory.getEventAllocator());
    assertNull(config.getAttrValueEscaperFactory());
    assertNull(config.getTextEscaperFactory());
    assertNull(config2.getDTDOverride());
    assertEquals(0, factory.getFormatGeneratorFeatures());
    assertEquals(0, versionResult.getMajorVersion());
    assertEquals(0, versionResult.getMinorVersion());
    assertEquals(0, versionResult.getPatchLevel());
    assertEquals(0, versionResult2.getPatchLevel());
    assertEquals(0, deserializationContext.getDeserializationFeatures());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, factory.getParserFeatures());
    assertEquals(1.0d, getResult2.getQualityValue());
    assertEquals(1.0d, getResult3.getQualityValue());
    assertEquals(1.0d, getResult.getQualityValue());
    assertEquals(1.0d, getResult4.getQualityValue());
    assertEquals(1000, config2.getMaxAttributesPerElement());
    assertEquals(1000, config2.getMaxElementDepth());
    assertEquals(100000L, config2.getMaxEntityCount());
    assertEquals(12, config2.getDtdCacheSize());
    assertEquals(14, versionResult2.getMinorVersion());
    assertEquals(2, factory.getFormatParserFeatures());
    assertEquals(2, versionResult2.getMajorVersion());
    assertEquals(2079, factory.getGeneratorFeatures());
    assertEquals(2147483647L, config2.getMaxTextLength());
    assertEquals(21771068, serializationConfig.getSerializationFeatures());
    assertEquals(2973191, config2.getConfigFlags());
    assertEquals(31, factory.getFactoryFeatures());
    assertEquals(4, objectMapper.getRegisteredModuleIds().size());
    assertEquals(4000, config2.getInputBufferLength());
    assertEquals(475047040, deserializationConfig.getDeserializationFeatures());
    assertEquals(500, config2.getMaxDtdDepth());
    assertEquals(500, config2.getMaxEntityDepth());
    assertEquals(524288, config2.getMaxAttributeSize());
    assertEquals(76, base64Variant.getMaxLineLength());
    assertEquals(935, config.getConfigFlags());
    JsonNodeFactory nodeFactory = objectMapper.getNodeFactory();
    assertEquals(9999, nodeFactory.getMaxElementIndexForInsert());
    assertEquals(JsonInclude.Include.ALWAYS, serializationConfig.getSerializationInclusion());
    assertEquals(JsonInclude.Include.USE_DEFAULTS, defaultPropertyInclusion.getContentInclusion());
    assertEquals(JsonInclude.Include.USE_DEFAULTS, defaultPropertyInclusion.getValueInclusion());
    JsonSetter.Value defaultSetterInfo = deserializationConfig.getDefaultSetterInfo();
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getContentNulls());
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getValueNulls());
    assertFalse(config2.isXml11());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult2.isSnapshot());
    assertFalse(versionResult2.isUknownVersion());
    assertFalse(versionResult2.isUnknownVersion());
    assertFalse(defaultNullKeySerializer.isUnwrappingSerializer());
    assertFalse(defaultNullValueSerializer.isUnwrappingSerializer());
    assertFalse(factoryConfig.hasAbstractTypeResolvers());
    assertFalse(deserializationConfig.hasExplicitTimeZone());
    assertFalse(serializationConfig.hasExplicitTimeZone());
    assertFalse(((ArrayIterator<Serializers>) serializersResult).hasNext());
    assertFalse(locale.hasExtensions());
    assertFalse(getResult.isConcrete());
    assertFalse(getResult2.isWildcardType());
    assertFalse(getResult3.isWildcardType());
    assertFalse(getResult.isWildcardType());
    assertFalse(getResult4.isWildcardType());
    assertTrue(versionResult.isUknownVersion());
    assertTrue(versionResult.isUnknownVersion());
    assertTrue(factoryConfig.hasDeserializerModifiers());
    assertTrue(factoryConfig.hasDeserializers());
    assertTrue(factoryConfig.hasKeyDeserializers());
    assertTrue(factoryConfig.hasValueInstantiators());
    assertTrue(deserializationConfig.isAnnotationProcessingEnabled());
    assertTrue(serializationConfig.isAnnotationProcessingEnabled());
    assertTrue(factoryConfig2.hasKeySerializers());
    assertTrue(factoryConfig2.hasSerializerModifiers());
    assertTrue(factoryConfig2.hasSerializers());
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult).hasNext());
    assertTrue(((StdDateFormat) dateFormat).isColonIncludedInTimeZone());
    assertTrue(dateFormat.isLenient());
    Map<String, String> parameters4 = getResult4.getParameters();
    assertTrue(parameters4.isEmpty());
    Set<Character> extensionKeys = locale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertTrue(getResult2.isConcrete());
    assertTrue(getResult3.isConcrete());
    assertTrue(getResult4.isConcrete());
    Class<FromXmlParser.Feature> expectedFormatReadFeatureType = FromXmlParser.Feature.class;
    assertEquals(expectedFormatReadFeatureType, factory.getFormatReadFeatureType());
    Class<ToXmlGenerator.Feature> expectedFormatWriteFeatureType = ToXmlGenerator.Feature.class;
    assertEquals(expectedFormatWriteFeatureType, factory.getFormatWriteFeatureType());
    assertEquals(Double.SIZE, config2.getShortestReportedTextSegment());
    assertEquals(Integer.MAX_VALUE, config2.getMaxChildrenPerElement());
    assertEquals(Long.MAX_VALUE, config2.getMaxCharacters());
    assertEquals(Long.MAX_VALUE, config2.getMaxElementCount());
    assertEquals('=', base64Variant.getPaddingByte());
    assertSame(versionResult, annotationIntrospector2.version());
    assertSame(factory, objectMapper.getJsonFactory());
    assertSame(nodeFactory, deserializationConfig.getNodeFactory());
    assertSame(serializationConfig, serializerProviderInstance.getConfig());
    assertSame(typeFactory, serializerProviderInstance.getTypeFactory());
    assertSame(typeFactory, deserializationConfig.getTypeFactory());
    assertSame(typeFactory, serializationConfig.getTypeFactory());
    assertSame(versionResult2, factory.version());
    assertSame(base64Variant, serializationConfig.getBase64Variant());
    assertSame(locale, serializerProviderInstance.getLocale());
    assertSame(locale, serializationConfig.getLocale());
    assertSame(timeZone, serializerProviderInstance.getTimeZone());
    assertSame(timeZone, serializationConfig.getTimeZone());
    assertSame(defaultPropertyInclusion, serializationConfig.getDefaultPropertyInclusion());
    assertSame(defaultSetterInfo, serializationConfig.getDefaultSetterInfo());
    assertSame(extensionKeys, locale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, locale.getUnicodeLocaleKeys());
    assertSame(charset, getResult3.getCharset());
    assertSame(charset, getResult.getCharset());
    assertSame(parameters4, config2.getCustomInternalEntities());
    assertSame(attributes, serializationConfig.getAttributes());
    assertSame(cacheProvider, serializationConfig.getCacheProvider());
    assertSame(annotationIntrospector2, serializerProviderInstance.getAnnotationIntrospector());
    assertSame(classIntrospector, serializationConfig.getClassIntrospector());
    assertSame(accessorNaming, serializationConfig.getAccessorNaming());
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
    assertSame(objectMapper, factory.getCodec());
  }

  /**
   * Test
   * {@link MappingJackson2XmlHttpMessageConverter#MappingJackson2XmlHttpMessageConverter(ObjectMapper)}.
   * <p>
   * Method under test:
   * {@link MappingJackson2XmlHttpMessageConverter#MappingJackson2XmlHttpMessageConverter(ObjectMapper)}
   */
  @Test
  @DisplayName("Test new MappingJackson2XmlHttpMessageConverter(ObjectMapper)")
  void testNewMappingJackson2XmlHttpMessageConverter2() {
    // Arrange
    XmlMapper objectMapper = new XmlMapper();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    objectMapper.addMixIn(target, mixinSource);

    // Act
    MappingJackson2XmlHttpMessageConverter actualMappingJackson2XmlHttpMessageConverter = new MappingJackson2XmlHttpMessageConverter(
        objectMapper);

    // Assert
    List<MediaType> supportedMediaTypes = actualMappingJackson2XmlHttpMessageConverter.getSupportedMediaTypes();
    assertEquals(3, supportedMediaTypes.size());
    MediaType getResult = supportedMediaTypes.get(2);
    assertEquals("*+xml", getResult.getSubtype());
    MediaType getResult2 = supportedMediaTypes.get(0);
    Charset charset = getResult2.getCharset();
    assertEquals("UTF-8", charset.name());
    Map<String, String> parameters = getResult2.getParameters();
    assertEquals(1, parameters.size());
    assertEquals("UTF-8", parameters.get("charset"));
    MediaType getResult3 = supportedMediaTypes.get(1);
    Map<String, String> parameters2 = getResult3.getParameters();
    assertEquals(1, parameters2.size());
    assertEquals("UTF-8", parameters2.get("charset"));
    Map<String, String> parameters3 = getResult.getParameters();
    assertEquals(1, parameters3.size());
    assertEquals("UTF-8", parameters3.get("charset"));
    assertEquals("application", getResult2.getType());
    assertEquals("application", getResult.getType());
    List<MediaType> mediaTypesForProblemDetail = actualMappingJackson2XmlHttpMessageConverter
        .getMediaTypesForProblemDetail();
    assertEquals(1, mediaTypesForProblemDetail.size());
    MediaType getResult4 = mediaTypesForProblemDetail.get(0);
    assertEquals("application", getResult4.getType());
    assertEquals("problem+xml", getResult4.getSubtype());
    assertEquals("text", getResult3.getType());
    assertEquals("xml", getResult2.getSubtype());
    assertEquals("xml", getResult3.getSubtype());
    assertEquals("xml", getResult.getSubtypeSuffix());
    assertEquals("xml", getResult4.getSubtypeSuffix());
    assertNull(getResult2.getSubtypeSuffix());
    assertNull(getResult3.getSubtypeSuffix());
    assertNull(actualMappingJackson2XmlHttpMessageConverter.getDefaultCharset());
    assertNull(getResult4.getCharset());
    assertEquals(1.0d, getResult2.getQualityValue());
    assertEquals(1.0d, getResult3.getQualityValue());
    assertEquals(1.0d, getResult.getQualityValue());
    assertEquals(1.0d, getResult4.getQualityValue());
    assertFalse(getResult.isConcrete());
    assertFalse(getResult2.isWildcardType());
    assertFalse(getResult3.isWildcardType());
    assertFalse(getResult.isWildcardType());
    assertFalse(getResult4.isWildcardType());
    assertTrue(getResult4.getParameters().isEmpty());
    assertTrue(getResult2.isConcrete());
    assertTrue(getResult3.isConcrete());
    assertTrue(getResult4.isConcrete());
    assertSame(objectMapper, actualMappingJackson2XmlHttpMessageConverter.getObjectMapper());
    assertSame(charset, getResult3.getCharset());
    assertSame(charset, getResult.getCharset());
  }

  /**
   * Test
   * {@link MappingJackson2XmlHttpMessageConverter#setObjectMapper(ObjectMapper)}.
   * <p>
   * Method under test:
   * {@link MappingJackson2XmlHttpMessageConverter#setObjectMapper(ObjectMapper)}
   */
  @Test
  @DisplayName("Test setObjectMapper(ObjectMapper)")
  void testSetObjectMapper() {
    // Arrange
    XmlMapper objectMapper = new XmlMapper();

    // Act
    mappingJackson2XmlHttpMessageConverter.setObjectMapper(objectMapper);

    // Assert
    assertSame(objectMapper, mappingJackson2XmlHttpMessageConverter.getObjectMapper());
  }

  /**
   * Test
   * {@link MappingJackson2XmlHttpMessageConverter#getMediaTypesForProblemDetail()}.
   * <p>
   * Method under test:
   * {@link MappingJackson2XmlHttpMessageConverter#getMediaTypesForProblemDetail()}
   */
  @Test
  @DisplayName("Test getMediaTypesForProblemDetail()")
  void testGetMediaTypesForProblemDetail() {
    // Arrange and Act
    List<MediaType> actualMediaTypesForProblemDetail = (new MappingJackson2XmlHttpMessageConverter())
        .getMediaTypesForProblemDetail();

    // Assert
    assertEquals(1, actualMediaTypesForProblemDetail.size());
    MediaType getResult = actualMediaTypesForProblemDetail.get(0);
    assertEquals("application", getResult.getType());
    assertEquals("problem+xml", getResult.getSubtype());
    assertEquals("xml", getResult.getSubtypeSuffix());
    assertNull(getResult.getCharset());
    assertEquals(1.0d, getResult.getQualityValue());
    assertFalse(getResult.isWildcardType());
    assertTrue(getResult.getParameters().isEmpty());
    assertTrue(getResult.isConcrete());
  }

  /**
   * Test
   * {@link MappingJackson2XmlHttpMessageConverter#canRead(Type, Class, MediaType)}
   * with {@code type}, {@code contextClass}, {@code mediaType}.
   * <ul>
   *   <li>When {@link AjTypeImpl}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MappingJackson2XmlHttpMessageConverter#canRead(Type, Class, MediaType)}
   */
  @Test
  @DisplayName("Test canRead(Type, Class, MediaType) with 'type', 'contextClass', 'mediaType'; when AjTypeImpl; then return 'false'")
  void testCanReadWithTypeContextClassMediaType_whenAjTypeImpl_thenReturnFalse() {
    // Arrange
    AjTypeImpl<Object> type = mock(AjTypeImpl.class);
    Class<Object> contextClass = Object.class;

    // Act and Assert
    assertFalse(mappingJackson2XmlHttpMessageConverter.canRead(type, contextClass, mock(MediaType.class)));
  }

  /**
   * Test
   * {@link MappingJackson2XmlHttpMessageConverter#canWrite(Class, MediaType)}
   * with {@code clazz}, {@code mediaType}.
   * <ul>
   *   <li>When {@link MediaType}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MappingJackson2XmlHttpMessageConverter#canWrite(Class, MediaType)}
   */
  @Test
  @DisplayName("Test canWrite(Class, MediaType) with 'clazz', 'mediaType'; when MediaType; then return 'false'")
  void testCanWriteWithClazzMediaType_whenMediaType_thenReturnFalse() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(mappingJackson2XmlHttpMessageConverter.canWrite(clazz, mock(MediaType.class)));
  }
}
