package org.thingsboard.server.controller;

import static org.mockito.Mockito.doNothing;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletResponse;
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
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class ComponentDescriptorControllerDiffblueTest {
  @InjectMocks
  private ComponentDescriptorController componentDescriptorController;

  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link ComponentDescriptorController#getComponentDescriptorsByType(String, String)}.
   * <p>
   * Method under test: {@link ComponentDescriptorController#getComponentDescriptorsByType(String, String)}
   */
  @Test
  @DisplayName("Test getComponentDescriptorsByType(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List ComponentDescriptorController.getComponentDescriptorsByType(String, String)"})
  void testGetComponentDescriptorsByType() throws Exception {
    // Arrange
    doNothing().when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/components/{componentType}",
        "Component Type");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(componentDescriptorController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
