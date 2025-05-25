package org.thingsboard.server.controller;

import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.WebRequest;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class TbResourceControllerDiffblueTest {
  @InjectMocks
  private TbResourceController tbResourceController;

  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link TbResourceController#downloadLwm2mResourceIfChanged(String, String)}.
   * <p>
   * Method under test: {@link TbResourceController#downloadLwm2mResourceIfChanged(String, String)}
   */
  @Test
  @DisplayName("Test downloadLwm2mResourceIfChanged(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity TbResourceController.downloadLwm2mResourceIfChanged(String, String)"})
  void testDownloadLwm2mResourceIfChanged() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TbResourceController#downloadLwm2mResourceIfChanged(String, String)}.
   * <p>
   * Method under test: {@link TbResourceController#downloadLwm2mResourceIfChanged(String, String)}
   */
  @Test
  @DisplayName("Test downloadLwm2mResourceIfChanged(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity TbResourceController.downloadLwm2mResourceIfChanged(String, String)"})
  void testDownloadLwm2mResourceIfChanged2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link TbResourceController#downloadPkcs12ResourceIfChanged(String, String)}.
   * <p>
   * Method under test: {@link TbResourceController#downloadPkcs12ResourceIfChanged(String, String)}
   */
  @Test
  @DisplayName("Test downloadPkcs12ResourceIfChanged(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity TbResourceController.downloadPkcs12ResourceIfChanged(String, String)"})
  void testDownloadPkcs12ResourceIfChanged() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TbResourceController#downloadPkcs12ResourceIfChanged(String, String)}.
   * <p>
   * Method under test: {@link TbResourceController#downloadPkcs12ResourceIfChanged(String, String)}
   */
  @Test
  @DisplayName("Test downloadPkcs12ResourceIfChanged(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity TbResourceController.downloadPkcs12ResourceIfChanged(String, String)"})
  void testDownloadPkcs12ResourceIfChanged2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link TbResourceController#downloadJksResourceIfChanged(String, String)}.
   * <p>
   * Method under test: {@link TbResourceController#downloadJksResourceIfChanged(String, String)}
   */
  @Test
  @DisplayName("Test downloadJksResourceIfChanged(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity TbResourceController.downloadJksResourceIfChanged(String, String)"})
  void testDownloadJksResourceIfChanged() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TbResourceController#downloadJksResourceIfChanged(String, String)}.
   * <p>
   * Method under test: {@link TbResourceController#downloadJksResourceIfChanged(String, String)}
   */
  @Test
  @DisplayName("Test downloadJksResourceIfChanged(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity TbResourceController.downloadJksResourceIfChanged(String, String)"})
  void testDownloadJksResourceIfChanged2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link TbResourceController#downloadJsResourceIfChanged(String, String)}.
   * <p>
   * Method under test: {@link TbResourceController#downloadJsResourceIfChanged(String, String)}
   */
  @Test
  @DisplayName("Test downloadJsResourceIfChanged(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity TbResourceController.downloadJsResourceIfChanged(String, String)"})
  void testDownloadJsResourceIfChanged() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TbResourceController#downloadJsResourceIfChanged(String, String)}.
   * <p>
   * Method under test: {@link TbResourceController#downloadJsResourceIfChanged(String, String)}
   */
  @Test
  @DisplayName("Test downloadJsResourceIfChanged(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity TbResourceController.downloadJsResourceIfChanged(String, String)"})
  void testDownloadJsResourceIfChanged2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link TbResourceController#deleteResource(String)}.
   * <p>
   * Method under test: {@link TbResourceController#deleteResource(String)}
   */
  @Test
  @DisplayName("Test deleteResource(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceController.deleteResource(String)"})
  void testDeleteResource() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link TbResourceController#deleteResource(String)}.
   * <p>
   * Method under test: {@link TbResourceController#deleteResource(String)}
   */
  @Test
  @DisplayName("Test deleteResource(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceController.deleteResource(String)"})
  void testDeleteResource2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }
}
