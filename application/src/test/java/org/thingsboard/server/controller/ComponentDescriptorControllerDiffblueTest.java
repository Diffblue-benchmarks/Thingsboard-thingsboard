package org.thingsboard.server.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComponentDescriptor ComponentDescriptorController.getComponentDescriptorByClazz(String)"
  })
  void testGetComponentDescriptorByClazz() throws Exception {
    // Arrange
    Optional<ComponentDescriptor> ofResult = Optional.of(new ComponentDescriptor());
    when(componentDiscoveryService.getComponent(Mockito.<String>any())).thenReturn(ofResult);
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/component/{componentDescriptorClazz:.+}", "U");
    requestBuilder.accept("U");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(componentDescriptorController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link ComponentDescriptorController#getComponentDescriptorByClazz(String)}.
   *
   * <p>Method under test: {@link
   * ComponentDescriptorController#getComponentDescriptorByClazz(String)}
   */
  @Test
  @DisplayName("Test getComponentDescriptorByClazz(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComponentDescriptor ComponentDescriptorController.getComponentDescriptorByClazz(String)"
  })
  void testGetComponentDescriptorByClazz2() throws Exception {
    // Arrange
    Optional<ComponentDescriptor> emptyResult = Optional.empty();
    when(componentDiscoveryService.getComponent(Mockito.<String>any())).thenReturn(emptyResult);
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/component/{componentDescriptorClazz:.+}", "U");
    requestBuilder.accept("U");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(componentDescriptorController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isOk());
  }

  /**
   * Test {@link ComponentDescriptorController#getComponentDescriptorsByTypes(String[], String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * ComponentDescriptorController#getComponentDescriptorsByTypes(String[], String)}
   */
  @Test
  @DisplayName("Test getComponentDescriptorsByTypes(String[], String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List ComponentDescriptorController.getComponentDescriptorsByTypes(String[], String)"
  })
  void testGetComponentDescriptorsByTypes_whenEmptyString() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/components").param("componentTypes", "");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(componentDescriptorController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List ComponentDescriptorController.getComponentDescriptorsByTypes(String[], String)"
  })
  void testGetComponentDescriptorsByTypes_whenValueOfArrayOfStringWithFoo() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/components")
            .param("componentTypes", String.valueOf(new String[] {"foo"}));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(componentDescriptorController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }
}
