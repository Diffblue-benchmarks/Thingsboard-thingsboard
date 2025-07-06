package org.thingsboard.server.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.plugin.ComponentDescriptor;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.component.ComponentDiscoveryService;

@ExtendWith(MockitoExtension.class)
class ComponentDescriptorControllerDiffblueTest {
  @InjectMocks private ComponentDescriptorController componentDescriptorController;

  @Mock private ComponentDiscoveryService componentDiscoveryService;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link ComponentDescriptorController#getComponentDescriptorByClazz(String)}.
   *
   * <p>Method under test: {@link
   * ComponentDescriptorController#getComponentDescriptorByClazz(String)}
   */
  @Test
  @DisplayName("Test getComponentDescriptorByClazz(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ComponentDescriptor ComponentDescriptorController.getComponentDescriptorByClazz(String)"
  })
  void testGetComponentDescriptorByClazz() throws Exception {
    // Arrange
    Optional<ComponentDescriptor> emptyResult = Optional.empty();
    when(componentDiscoveryService.getComponent(Mockito.<String>any())).thenReturn(emptyResult);
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/component/{componentDescriptorClazz:.+}", "U");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(componentDescriptorController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link ComponentDescriptorController#getComponentDescriptorByClazz(String)}.
   *
   * <ul>
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ComponentDescriptorController#getComponentDescriptorByClazz(String)}
   */
  @Test
  @DisplayName(
      "Test getComponentDescriptorByClazz(String); then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ComponentDescriptor ComponentDescriptorController.getComponentDescriptorByClazz(String)"
  })
  void testGetComponentDescriptorByClazz_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    Optional<ComponentDescriptor> ofResult = Optional.of(new ComponentDescriptor());
    when(componentDiscoveryService.getComponent(Mockito.<String>any())).thenReturn(ofResult);
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/component/{componentDescriptorClazz:.+}", "U");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(componentDescriptorController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(
            MockMvcResultMatchers.content()
                .string(
                    "{\"id\":null,\"createdTime\":0,\"type\":null,\"scope\":null,\"clusteringMode\":null,\"name\":null,\"clazz\":null,"
                        + "\"configurationVersion\":0,\"actions\":null,\"hasQueueName\":false,\"configurationDescriptor\":null}"));
  }

  /**
   * Test {@link ComponentDescriptorController#getComponentDescriptorsByType(String, String)}.
   *
   * <p>Method under test: {@link
   * ComponentDescriptorController#getComponentDescriptorsByType(String, String)}
   */
  @Test
  @DisplayName("Test getComponentDescriptorsByType(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List ComponentDescriptorController.getComponentDescriptorsByType(String, String)"
  })
  void testGetComponentDescriptorsByType() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/components/{componentType}", "Component Type");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(componentDescriptorController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link ComponentDescriptorController#getComponentDescriptorsByTypes(String[], String)}.
   *
   * <ul>
   *   <li>When valueOf array of {@link String} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ComponentDescriptorController#getComponentDescriptorsByTypes(String[], String)}
   */
  @Test
  @DisplayName(
      "Test getComponentDescriptorsByTypes(String[], String); when valueOf array of String with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List ComponentDescriptorController.getComponentDescriptorsByTypes(String[], String)"
  })
  void testGetComponentDescriptorsByTypes_whenValueOfArrayOfStringWithFoo() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/components");
    MockHttpServletRequestBuilder requestBuilder =
        getResult.param("componentTypes", String.valueOf(new String[] {"foo"}));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(componentDescriptorController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link ComponentDescriptorController#getComponentDescriptorsByTypes(String[], String)}.
   *
   * <ul>
   *   <li>When valueOf empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * ComponentDescriptorController#getComponentDescriptorsByTypes(String[], String)}
   */
  @Test
  @DisplayName("Test getComponentDescriptorsByTypes(String[], String); when valueOf empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List ComponentDescriptorController.getComponentDescriptorsByTypes(String[], String)"
  })
  void testGetComponentDescriptorsByTypes_whenValueOfEmptyString() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/components");
    MockHttpServletRequestBuilder requestBuilder =
        getResult.param("componentTypes", String.valueOf(""));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(componentDescriptorController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
