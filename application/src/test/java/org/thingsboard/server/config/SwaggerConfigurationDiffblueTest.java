package org.thingsboard.server.config;

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
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverter;
import io.swagger.v3.core.converter.ModelConverterContext;
import io.swagger.v3.core.converter.ModelConverterContextImpl;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.media.Schema;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigProperties;

class SwaggerConfigurationDiffblueTest {
  /**
   * Test {@link SwaggerConfiguration#thingsboardApi()}.
   * <p>
   * Method under test: {@link SwaggerConfiguration#thingsboardApi()}
   */
  @Test
  @DisplayName("Test thingsboardApi()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OpenAPI SwaggerConfiguration.thingsboardApi()"})
  void testThingsboardApi() {
    // Arrange and Act
    OpenAPI actualThingsboardApiResult = (new SwaggerConfiguration()).thingsboardApi();

    // Assert
    assertEquals("3.0.1", actualThingsboardApiResult.getOpenapi());
    assertNull(actualThingsboardApiResult.getExternalDocs());
    assertNull(actualThingsboardApiResult.getJsonSchemaDialect());
    assertNull(actualThingsboardApiResult.getSecurity());
    assertNull(actualThingsboardApiResult.getServers());
    assertNull(actualThingsboardApiResult.getTags());
    assertNull(actualThingsboardApiResult.getWebhooks());
    assertNull(actualThingsboardApiResult.getExtensions());
    Paths paths = actualThingsboardApiResult.getPaths();
    assertEquals(1, paths.size());
    assertEquals(SpecVersion.V30, actualThingsboardApiResult.getSpecVersion());
    assertTrue(paths.containsKey(SwaggerConfiguration.LOGIN_ENDPOINT));
  }

  /**
   * Test {@link SwaggerConfiguration#springDocConfig(SpringDocConfigProperties)}.
   * <ul>
   *   <li>Then {@link SpringDocConfigProperties} (default constructor) SpecVersion is {@code V31}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SwaggerConfiguration#springDocConfig(SpringDocConfigProperties)}
   */
  @Test
  @DisplayName("Test springDocConfig(SpringDocConfigProperties); then SpringDocConfigProperties (default constructor) SpecVersion is 'V31'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SpringDocConfigProperties SwaggerConfiguration.springDocConfig(SpringDocConfigProperties)"})
  void testSpringDocConfig_thenSpringDocConfigPropertiesSpecVersionIsV31() {
    // Arrange
    SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration();
    SpringDocConfigProperties springDocProperties = new SpringDocConfigProperties();

    // Act
    SpringDocConfigProperties actualSpringDocConfigResult = swaggerConfiguration.springDocConfig(springDocProperties);

    // Assert
    assertEquals(SpecVersion.V31, springDocProperties.getSpecVersion());
    assertFalse(springDocProperties.isRemoveBrokenReferenceDefinitions());
    assertTrue(springDocProperties.isOpenapi31());
    assertSame(springDocProperties, actualSpringDocConfigResult);
  }

  /**
   * Test {@link SwaggerConfiguration#swaggerUiConfig(SwaggerUiConfigProperties)}.
   * <ul>
   *   <li>Then {@link SwaggerUiConfigProperties} (default constructor) OperationsSorter is {@code alpha}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SwaggerConfiguration#swaggerUiConfig(SwaggerUiConfigProperties)}
   */
  @Test
  @DisplayName("Test swaggerUiConfig(SwaggerUiConfigProperties); then SwaggerUiConfigProperties (default constructor) OperationsSorter is 'alpha'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SwaggerUiConfigProperties SwaggerConfiguration.swaggerUiConfig(SwaggerUiConfigProperties)"})
  void testSwaggerUiConfig_thenSwaggerUiConfigPropertiesOperationsSorterIsAlpha() {
    // Arrange
    SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration();
    SwaggerUiConfigProperties uiProperties = new SwaggerUiConfigProperties();

    // Act
    SwaggerUiConfigProperties actualSwaggerUiConfigResult = swaggerConfiguration.swaggerUiConfig(uiProperties);

    // Assert
    assertEquals("alpha", uiProperties.getOperationsSorter());
    assertEquals("alpha", uiProperties.getTagsSorter());
    assertEquals("example", uiProperties.getDefaultModelRendering());
    assertEquals("list", uiProperties.getDocExpansion());
    assertEquals(1, uiProperties.getDefaultModelExpandDepth().intValue());
    assertEquals(1, uiProperties.getDefaultModelsExpandDepth().intValue());
    assertFalse(uiProperties.getDisplayOperationId());
    assertFalse(uiProperties.getDisplayRequestDuration());
    assertFalse(uiProperties.getShowCommonExtensions());
    assertFalse(uiProperties.getShowExtensions());
    assertTrue(uiProperties.getDeepLinking());
    assertTrue(uiProperties.getPersistAuthorization());
    String expectedFilter = Boolean.FALSE.toString();
    assertEquals(expectedFilter, uiProperties.getFilter());
    assertSame(uiProperties, actualSwaggerUiConfigResult);
  }

  /**
   * Test {@link SwaggerConfiguration#mapAwareConverter()}.
   * <p>
   * Method under test: {@link SwaggerConfiguration#mapAwareConverter()}
   */
  @Test
  @DisplayName("Test mapAwareConverter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelConverter SwaggerConfiguration.mapAwareConverter()"})
  void testMapAwareConverter() {
    // Arrange and Act
    ModelConverter actualMapAwareConverterResult = (new SwaggerConfiguration()).mapAwareConverter();
    AnnotatedType annotatedType = new AnnotatedType();
    ModelConverterContextImpl modelConverterContextImpl = new ModelConverterContextImpl(mock(ModelConverter.class));
    ArrayList<ModelConverter> modelConverterList = new ArrayList<>();
    Iterator<ModelConverter> iteratorResult = modelConverterList.iterator();

    // Assert
    assertNull(actualMapAwareConverterResult.resolve(annotatedType, modelConverterContextImpl, iteratorResult));
    assertFalse(actualMapAwareConverterResult.isOpenapi31());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link SwaggerConfiguration#mapAwareConverter()}.
   * <p>
   * Method under test: {@link SwaggerConfiguration#mapAwareConverter()}
   */
  @Test
  @DisplayName("Test mapAwareConverter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ModelConverter SwaggerConfiguration.mapAwareConverter()"})
  void testMapAwareConverter2() {
    // Arrange and Act
    ModelConverter actualMapAwareConverterResult = (new SwaggerConfiguration()).mapAwareConverter();
    AnnotatedType annotatedType = mock(AnnotatedType.class);
    when(annotatedType.getType()).thenReturn(new PlaceholderForType(1));
    ModelConverterContextImpl modelConverterContextImpl = new ModelConverterContextImpl(mock(ModelConverter.class));
    ModelConverter modelConverter = mock(ModelConverter.class);
    Schema schema = new Schema();
    when(modelConverter.resolve(Mockito.<AnnotatedType>any(), Mockito.<ModelConverterContext>any(),
        Mockito.<Iterator<ModelConverter>>any())).thenReturn(schema);
    ArrayList<ModelConverter> modelConverterList = new ArrayList<>();
    modelConverterList.add(modelConverter);
    Iterator<ModelConverter> iteratorResult = modelConverterList.iterator();
    Schema actualResolveResult = actualMapAwareConverterResult.resolve(annotatedType, modelConverterContextImpl,
        iteratorResult);

    // Assert
    verify(annotatedType).getType();
    verify(modelConverter).resolve(isA(AnnotatedType.class), isA(ModelConverterContext.class), isA(Iterator.class));
    assertFalse(iteratorResult.hasNext());
    assertSame(schema, actualResolveResult);
  }
}
