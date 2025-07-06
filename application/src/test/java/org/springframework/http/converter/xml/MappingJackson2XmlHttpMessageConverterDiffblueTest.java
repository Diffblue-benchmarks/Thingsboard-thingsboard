package org.springframework.http.converter.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.classmate.types.TypePlaceHolder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker.Std;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.deser.XmlDeserializationContext;
import com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider;
import java.lang.reflect.Type;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MappingJackson2XmlHttpMessageConverter.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class MappingJackson2XmlHttpMessageConverterDiffblueTest {
  @Autowired private MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter;

  /**
   * Test {@link MappingJackson2XmlHttpMessageConverter#MappingJackson2XmlHttpMessageConverter()}.
   *
   * <p>Method under test: {@link
   * MappingJackson2XmlHttpMessageConverter#MappingJackson2XmlHttpMessageConverter()}
   */
  @Test
  @DisplayName("Test new MappingJackson2XmlHttpMessageConverter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MappingJackson2XmlHttpMessageConverter.<init>()"})
  void testNewMappingJackson2XmlHttpMessageConverter() {
    // Arrange and Act
    MappingJackson2XmlHttpMessageConverter actualMappingJackson2XmlHttpMessageConverter =
        new MappingJackson2XmlHttpMessageConverter();

    // Assert
    ObjectMapper objectMapper = actualMappingJackson2XmlHttpMessageConverter.getObjectMapper();
    assertTrue(objectMapper.getVisibilityChecker() instanceof Std);
    assertTrue(objectMapper.getPolymorphicTypeValidator() instanceof LaissezFaireSubTypeValidator);
    assertTrue(objectMapper.getSubtypeResolver() instanceof StdSubtypeResolver);
    assertTrue(objectMapper.getSerializerFactory() instanceof BeanSerializerFactory);
    assertTrue(objectMapper.getDateFormat() instanceof StdDateFormat);
    assertTrue(objectMapper instanceof XmlMapper);
    assertTrue(objectMapper.getDeserializationContext() instanceof XmlDeserializationContext);
    assertTrue(objectMapper.getSerializerProvider() instanceof XmlSerializerProvider);
    assertTrue(objectMapper.getSerializerProviderInstance() instanceof XmlSerializerProvider);
    assertNull(objectMapper.getInjectableValues());
    assertNull(objectMapper.getPropertyNamingStrategy());
    assertNull(actualMappingJackson2XmlHttpMessageConverter.getDefaultCharset());
    assertEquals(
        1, actualMappingJackson2XmlHttpMessageConverter.getMediaTypesForProblemDetail().size());
    assertEquals(3, actualMappingJackson2XmlHttpMessageConverter.getSupportedMediaTypes().size());
    assertEquals(4, objectMapper.getRegisteredModuleIds().size());
  }

  /**
   * Test {@link
   * MappingJackson2XmlHttpMessageConverter#MappingJackson2XmlHttpMessageConverter(ObjectMapper)}.
   *
   * <ul>
   *   <li>Then return DefaultCharset is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MappingJackson2XmlHttpMessageConverter#MappingJackson2XmlHttpMessageConverter(ObjectMapper)}
   */
  @Test
  @DisplayName(
      "Test new MappingJackson2XmlHttpMessageConverter(ObjectMapper); then return DefaultCharset is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MappingJackson2XmlHttpMessageConverter.<init>(ObjectMapper)"})
  void testNewMappingJackson2XmlHttpMessageConverter_thenReturnDefaultCharsetIsNull() {
    // Arrange
    XmlMapper objectMapper = new XmlMapper();

    // Act
    MappingJackson2XmlHttpMessageConverter actualMappingJackson2XmlHttpMessageConverter =
        new MappingJackson2XmlHttpMessageConverter(objectMapper);

    // Assert
    assertNull(actualMappingJackson2XmlHttpMessageConverter.getDefaultCharset());
    assertEquals(
        1, actualMappingJackson2XmlHttpMessageConverter.getMediaTypesForProblemDetail().size());
    assertEquals(3, actualMappingJackson2XmlHttpMessageConverter.getSupportedMediaTypes().size());
    assertSame(objectMapper, actualMappingJackson2XmlHttpMessageConverter.getObjectMapper());
  }

  /**
   * Test {@link MappingJackson2XmlHttpMessageConverter#setObjectMapper(ObjectMapper)}.
   *
   * <p>Method under test: {@link
   * MappingJackson2XmlHttpMessageConverter#setObjectMapper(ObjectMapper)}
   */
  @Test
  @DisplayName("Test setObjectMapper(ObjectMapper)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MappingJackson2XmlHttpMessageConverter.setObjectMapper(ObjectMapper)"})
  void testSetObjectMapper() {
    // Arrange
    XmlMapper objectMapper = new XmlMapper();

    // Act
    mappingJackson2XmlHttpMessageConverter.setObjectMapper(objectMapper);

    // Assert
    assertSame(objectMapper, mappingJackson2XmlHttpMessageConverter.getObjectMapper());
  }

  /**
   * Test {@link MappingJackson2XmlHttpMessageConverter#setObjectMapper(ObjectMapper)}.
   *
   * <p>Method under test: {@link
   * MappingJackson2XmlHttpMessageConverter#setObjectMapper(ObjectMapper)}
   */
  @Test
  @DisplayName("Test setObjectMapper(ObjectMapper)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MappingJackson2XmlHttpMessageConverter.setObjectMapper(ObjectMapper)"})
  void testSetObjectMapper2() {
    // Arrange
    XmlMapper objectMapper = mock(XmlMapper.class);
    when(objectMapper.addMixIn(Mockito.<Class<?>>any(), Mockito.<Class<?>>any()))
        .thenReturn(JsonMapper.builder().findAndAddModules().build());
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    objectMapper.addMixIn(target, mixinSource);

    // Act
    mappingJackson2XmlHttpMessageConverter.setObjectMapper(objectMapper);

    // Assert
    verify(objectMapper).addMixIn(isA(Class.class), isA(Class.class));
    assertSame(objectMapper, mappingJackson2XmlHttpMessageConverter.getObjectMapper());
  }

  /**
   * Test {@link MappingJackson2XmlHttpMessageConverter#setObjectMapper(ObjectMapper)}.
   *
   * <p>Method under test: {@link
   * MappingJackson2XmlHttpMessageConverter#setObjectMapper(ObjectMapper)}
   */
  @Test
  @DisplayName("Test setObjectMapper(ObjectMapper)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MappingJackson2XmlHttpMessageConverter.setObjectMapper(ObjectMapper)"})
  void testSetObjectMapper3() {
    // Arrange
    MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter =
        new MappingJackson2XmlHttpMessageConverter();
    mappingJackson2XmlHttpMessageConverter.setPrettyPrint(true);
    XmlMapper objectMapper = new XmlMapper();

    // Act
    mappingJackson2XmlHttpMessageConverter.setObjectMapper(objectMapper);

    // Assert
    assertEquals(21771070, objectMapper.getSerializationConfig().getSerializationFeatures());
    assertSame(objectMapper, mappingJackson2XmlHttpMessageConverter.getObjectMapper());
  }

  /**
   * Test {@link MappingJackson2XmlHttpMessageConverter#setObjectMapper(ObjectMapper)}.
   *
   * <p>Method under test: {@link
   * MappingJackson2XmlHttpMessageConverter#setObjectMapper(ObjectMapper)}
   */
  @Test
  @DisplayName("Test setObjectMapper(ObjectMapper)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MappingJackson2XmlHttpMessageConverter.setObjectMapper(ObjectMapper)"})
  void testSetObjectMapper4() {
    // Arrange
    MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter =
        new MappingJackson2XmlHttpMessageConverter();
    mappingJackson2XmlHttpMessageConverter.setPrettyPrint(false);
    XmlMapper objectMapper = new XmlMapper();

    // Act
    mappingJackson2XmlHttpMessageConverter.setObjectMapper(objectMapper);

    // Assert
    assertEquals(21771068, objectMapper.getSerializationConfig().getSerializationFeatures());
    assertSame(objectMapper, mappingJackson2XmlHttpMessageConverter.getObjectMapper());
  }

  /**
   * Test {@link MappingJackson2XmlHttpMessageConverter#getMediaTypesForProblemDetail()}.
   *
   * <p>Method under test: {@link
   * MappingJackson2XmlHttpMessageConverter#getMediaTypesForProblemDetail()}
   */
  @Test
  @DisplayName("Test getMediaTypesForProblemDetail()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List MappingJackson2XmlHttpMessageConverter.getMediaTypesForProblemDetail()"})
  void testGetMediaTypesForProblemDetail() {
    // Arrange and Act
    List<MediaType> actualMediaTypesForProblemDetail =
        new MappingJackson2XmlHttpMessageConverter().getMediaTypesForProblemDetail();

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
   * Test {@link MappingJackson2XmlHttpMessageConverter#canRead(Type, Class, MediaType)} with {@code
   * type}, {@code contextClass}, {@code mediaType}.
   *
   * <ul>
   *   <li>When {@link MediaType}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MappingJackson2XmlHttpMessageConverter#canRead(Type, Class,
   * MediaType)}
   */
  @Test
  @DisplayName(
      "Test canRead(Type, Class, MediaType) with 'type', 'contextClass', 'mediaType'; when MediaType; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MappingJackson2XmlHttpMessageConverter.canRead(Type, Class, MediaType)"
  })
  void testCanReadWithTypeContextClassMediaType_whenMediaType_thenReturnFalse() {
    // Arrange
    TypePlaceHolder type = new TypePlaceHolder(1);
    Class<Object> contextClass = Object.class;

    // Act and Assert
    assertFalse(
        mappingJackson2XmlHttpMessageConverter.canRead(type, contextClass, mock(MediaType.class)));
  }

  /**
   * Test {@link MappingJackson2XmlHttpMessageConverter#canWrite(Class, MediaType)} with {@code
   * clazz}, {@code mediaType}.
   *
   * <ul>
   *   <li>When {@link MediaType}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MappingJackson2XmlHttpMessageConverter#canWrite(Class, MediaType)}
   */
  @Test
  @DisplayName(
      "Test canWrite(Class, MediaType) with 'clazz', 'mediaType'; when MediaType; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MappingJackson2XmlHttpMessageConverter.canWrite(Class, MediaType)"})
  void testCanWriteWithClazzMediaType_whenMediaType_thenReturnFalse() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(mappingJackson2XmlHttpMessageConverter.canWrite(clazz, mock(MediaType.class)));
  }
}
