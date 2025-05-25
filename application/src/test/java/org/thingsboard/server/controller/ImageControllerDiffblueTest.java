package org.thingsboard.server.controller;

import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.WebRequest;
import org.thingsboard.server.common.data.ImageExportData;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class ImageControllerDiffblueTest {
  @InjectMocks
  private ImageController imageController;

  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link ImageController#updateImagePublicStatus(String, String, boolean)}.
   * <p>
   * Method under test: {@link ImageController#updateImagePublicStatus(String, String, boolean)}
   */
  @Test
  @DisplayName("Test updateImagePublicStatus(String, String, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.TbResourceInfo ImageController.updateImagePublicStatus(String, String, boolean)"})
  void testUpdateImagePublicStatus() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link ImageController#updateImagePublicStatus(String, String, boolean)}.
   * <p>
   * Method under test: {@link ImageController#updateImagePublicStatus(String, String, boolean)}
   */
  @Test
  @DisplayName("Test updateImagePublicStatus(String, String, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.TbResourceInfo ImageController.updateImagePublicStatus(String, String, boolean)"})
  void testUpdateImagePublicStatus2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link ImageController#downloadImage(String, String, String)}.
   * <p>
   * Method under test: {@link ImageController#downloadImage(String, String, String)}
   */
  @Test
  @DisplayName("Test downloadImage(String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity ImageController.downloadImage(String, String, String)"})
  void testDownloadImage() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link ImageController#downloadImage(String, String, String)}.
   * <p>
   * Method under test: {@link ImageController#downloadImage(String, String, String)}
   */
  @Test
  @DisplayName("Test downloadImage(String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity ImageController.downloadImage(String, String, String)"})
  void testDownloadImage2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link ImageController#exportImage(String, String)}.
   * <p>
   * Method under test: {@link ImageController#exportImage(String, String)}
   */
  @Test
  @DisplayName("Test exportImage(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImageExportData ImageController.exportImage(String, String)"})
  void testExportImage() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link ImageController#exportImage(String, String)}.
   * <p>
   * Method under test: {@link ImageController#exportImage(String, String)}
   */
  @Test
  @DisplayName("Test exportImage(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImageExportData ImageController.exportImage(String, String)"})
  void testExportImage2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link ImageController#importImage(ImageExportData)}.
   * <p>
   * Method under test: {@link ImageController#importImage(ImageExportData)}
   */
  @Test
  @DisplayName("Test importImage(ImageExportData)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.TbResourceInfo ImageController.importImage(ImageExportData)"})
  void testImportImage() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.put("/api/image/import");
    putResult.characterEncoding("https://example.org/example");

    ImageExportData imageExportData = new ImageExportData();
    imageExportData.setData("Data");
    imageExportData.setFileName("foo.txt");
    imageExportData.setMediaType("Media Type");
    imageExportData.setPublic(true);
    imageExportData.setPublicResourceKey("Public Resource Key");
    imageExportData.setResourceKey("Resource Key");
    imageExportData.setSubType("Sub Type");
    imageExportData.setTitle("Dr");
    String content = (new ObjectMapper()).writeValueAsString(imageExportData);
    MockHttpServletRequestBuilder requestBuilder = putResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link ImageController#downloadImagePreview(String, String, String)}.
   * <p>
   * Method under test: {@link ImageController#downloadImagePreview(String, String, String)}
   */
  @Test
  @DisplayName("Test downloadImagePreview(String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity ImageController.downloadImagePreview(String, String, String)"})
  void testDownloadImagePreview() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link ImageController#downloadImagePreview(String, String, String)}.
   * <p>
   * Method under test: {@link ImageController#downloadImagePreview(String, String, String)}
   */
  @Test
  @DisplayName("Test downloadImagePreview(String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity ImageController.downloadImagePreview(String, String, String)"})
  void testDownloadImagePreview2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link ImageController#getImageInfo(String, String)}.
   * <p>
   * Method under test: {@link ImageController#getImageInfo(String, String)}
   */
  @Test
  @DisplayName("Test getImageInfo(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.TbResourceInfo ImageController.getImageInfo(String, String)"})
  void testGetImageInfo() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link ImageController#getImageInfo(String, String)}.
   * <p>
   * Method under test: {@link ImageController#getImageInfo(String, String)}
   */
  @Test
  @DisplayName("Test getImageInfo(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.TbResourceInfo ImageController.getImageInfo(String, String)"})
  void testGetImageInfo2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link ImageController#getImages(int, int, String, boolean, String, String, String)}.
   * <p>
   * Method under test: {@link ImageController#getImages(int, int, String, boolean, String, String, String)}
   */
  @Test
  @DisplayName("Test getImages(int, int, String, boolean, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.page.PageData ImageController.getImages(int, int, String, boolean, String, String, String)"})
  void testGetImages() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/api/images")
        .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link ImageController#deleteImage(String, String, boolean)}.
   * <p>
   * Method under test: {@link ImageController#deleteImage(String, String, boolean)}
   */
  @Test
  @DisplayName("Test deleteImage(String, String, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity ImageController.deleteImage(String, String, boolean)"})
  void testDeleteImage() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link ImageController#deleteImage(String, String, boolean)}.
   * <p>
   * Method under test: {@link ImageController#deleteImage(String, String, boolean)}
   */
  @Test
  @DisplayName("Test deleteImage(String, String, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity ImageController.deleteImage(String, String, boolean)"})
  void testDeleteImage2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }
}
