package org.thingsboard.server.controller;

import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.UUID;
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
import org.thingsboard.server.common.data.ResourceSubType;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class TbResourceControllerDiffblueTest {
  @InjectMocks private TbResourceController tbResourceController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link TbResourceController#downloadResource(String)}.
   *
   * <p>Method under test: {@link TbResourceController#downloadResource(String)}
   */
  @Test
  @DisplayName("Test downloadResource(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity TbResourceController.downloadResource(String)"})
  void testDownloadResource() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
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
   * Test {@link TbResourceController#downloadResource(String)}.
   *
   * <p>Method under test: {@link TbResourceController#downloadResource(String)}
   */
  @Test
  @DisplayName("Test downloadResource(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity TbResourceController.downloadResource(String)"})
  void testDownloadResource2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link TbResourceController#downloadResourceIfChanged(String, String, String, String)}
   * with {@code resourceTypeStr}, {@code scope}, {@code key}, {@code etag}.
   *
   * <p>Method under test: {@link TbResourceController#downloadResourceIfChanged(String, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test downloadResourceIfChanged(String, String, String, String) with 'resourceTypeStr', 'scope', 'key', 'etag'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ResponseEntity TbResourceController.downloadResourceIfChanged(String, String, String, String)"
  })
  void testDownloadResourceIfChangedWithResourceTypeStrScopeKeyEtag() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
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
   * Test {@link TbResourceController#downloadResourceIfChanged(String, String, String, String)}
   * with {@code resourceTypeStr}, {@code scope}, {@code key}, {@code etag}.
   *
   * <p>Method under test: {@link TbResourceController#downloadResourceIfChanged(String, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test downloadResourceIfChanged(String, String, String, String) with 'resourceTypeStr', 'scope', 'key', 'etag'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ResponseEntity TbResourceController.downloadResourceIfChanged(String, String, String, String)"
  })
  void testDownloadResourceIfChangedWithResourceTypeStrScopeKeyEtag2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link TbResourceController#downloadLwm2mResourceIfChanged(String, String)}.
   *
   * <p>Method under test: {@link TbResourceController#downloadLwm2mResourceIfChanged(String,
   * String)}
   */
  @Test
  @DisplayName("Test downloadLwm2mResourceIfChanged(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ResponseEntity TbResourceController.downloadLwm2mResourceIfChanged(String, String)"
  })
  void testDownloadLwm2mResourceIfChanged() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
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
   *
   * <p>Method under test: {@link TbResourceController#downloadLwm2mResourceIfChanged(String,
   * String)}
   */
  @Test
  @DisplayName("Test downloadLwm2mResourceIfChanged(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ResponseEntity TbResourceController.downloadLwm2mResourceIfChanged(String, String)"
  })
  void testDownloadLwm2mResourceIfChanged2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link TbResourceController#downloadPkcs12ResourceIfChanged(String, String)}.
   *
   * <p>Method under test: {@link TbResourceController#downloadPkcs12ResourceIfChanged(String,
   * String)}
   */
  @Test
  @DisplayName("Test downloadPkcs12ResourceIfChanged(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ResponseEntity TbResourceController.downloadPkcs12ResourceIfChanged(String, String)"
  })
  void testDownloadPkcs12ResourceIfChanged() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
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
   *
   * <p>Method under test: {@link TbResourceController#downloadPkcs12ResourceIfChanged(String,
   * String)}
   */
  @Test
  @DisplayName("Test downloadPkcs12ResourceIfChanged(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ResponseEntity TbResourceController.downloadPkcs12ResourceIfChanged(String, String)"
  })
  void testDownloadPkcs12ResourceIfChanged2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link TbResourceController#downloadJksResourceIfChanged(String, String)}.
   *
   * <p>Method under test: {@link TbResourceController#downloadJksResourceIfChanged(String, String)}
   */
  @Test
  @DisplayName("Test downloadJksResourceIfChanged(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ResponseEntity TbResourceController.downloadJksResourceIfChanged(String, String)"
  })
  void testDownloadJksResourceIfChanged() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
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
   *
   * <p>Method under test: {@link TbResourceController#downloadJksResourceIfChanged(String, String)}
   */
  @Test
  @DisplayName("Test downloadJksResourceIfChanged(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ResponseEntity TbResourceController.downloadJksResourceIfChanged(String, String)"
  })
  void testDownloadJksResourceIfChanged2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link TbResourceController#downloadJsResourceIfChanged(String, String)}.
   *
   * <p>Method under test: {@link TbResourceController#downloadJsResourceIfChanged(String, String)}
   */
  @Test
  @DisplayName("Test downloadJsResourceIfChanged(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ResponseEntity TbResourceController.downloadJsResourceIfChanged(String, String)"
  })
  void testDownloadJsResourceIfChanged() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
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
   *
   * <p>Method under test: {@link TbResourceController#downloadJsResourceIfChanged(String, String)}
   */
  @Test
  @DisplayName("Test downloadJsResourceIfChanged(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ResponseEntity TbResourceController.downloadJsResourceIfChanged(String, String)"
  })
  void testDownloadJsResourceIfChanged2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link TbResourceController#getResourceInfoById(String)}.
   *
   * <p>Method under test: {@link TbResourceController#getResourceInfoById(String)}
   */
  @Test
  @DisplayName("Test getResourceInfoById(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbResourceInfo TbResourceController.getResourceInfoById(String)"})
  void testGetResourceInfoById() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
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
   * Test {@link TbResourceController#getResourceInfoById(String)}.
   *
   * <p>Method under test: {@link TbResourceController#getResourceInfoById(String)}
   */
  @Test
  @DisplayName("Test getResourceInfoById(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbResourceInfo TbResourceController.getResourceInfoById(String)"})
  void testGetResourceInfoById2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link TbResourceController#getResourceById(String)}.
   *
   * <p>Method under test: {@link TbResourceController#getResourceById(String)}
   */
  @Test
  @DisplayName("Test getResourceById(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbResource TbResourceController.getResourceById(String)"})
  void testGetResourceById() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
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
   * Test {@link TbResourceController#getResourceById(String)}.
   *
   * <p>Method under test: {@link TbResourceController#getResourceById(String)}
   */
  @Test
  @DisplayName("Test getResourceById(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbResource TbResourceController.getResourceById(String)"})
  void testGetResourceById2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link TbResourceController#saveResource(TbResource)}.
   *
   * <p>Method under test: {@link TbResourceController#saveResource(TbResource)}
   */
  @Test
  @DisplayName("Test saveResource(TbResource)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbResourceInfo TbResourceController.saveResource(TbResource)"})
  void testSaveResource() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/resource");
    postResult.characterEncoding("https://example.org/example");

    TbResource tbResource = new TbResource();
    tbResource.setCreatedTime(1L);
    tbResource.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResource.setDescriptor(DoubleNode.valueOf(10.0d));
    tbResource.setDescriptorValue("Value");
    tbResource.setEtag("Etag");
    tbResource.setExternalId(
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tbResource.setFileName("foo.txt");
    tbResource.setId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tbResource.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResource.setPublic(true);
    tbResource.setPublicResourceKey("Public Resource Key");
    tbResource.setResourceKey("Resource Key");
    tbResource.setResourceSubType(ResourceSubType.IMAGE);
    tbResource.setResourceType(ResourceType.LWM2M_MODEL);
    tbResource.setSearchText("Search Text");
    tbResource.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tbResource.setTitle("Dr");
    String content = new ObjectMapper().writeValueAsString(tbResource);
    MockHttpServletRequestBuilder requestBuilder =
        postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link TbResourceController#getResources(int, int, String, String, String, String)}.
   *
   * <p>Method under test: {@link TbResourceController#getResources(int, int, String, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test getResources(int, int, String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData TbResourceController.getResources(int, int, String, String, String, String)"
  })
  void testGetResources() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/resource").param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link TbResourceController#getTenantResources(int, int, String, String, String)}.
   *
   * <p>Method under test: {@link TbResourceController#getTenantResources(int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName("Test getTenantResources(int, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData TbResourceController.getTenantResources(int, int, String, String, String)"
  })
  void testGetTenantResources() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/resource/tenant")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link TbResourceController#getLwm2mListObjectsPage(int, int, String, String, String)}.
   *
   * <p>Method under test: {@link TbResourceController#getLwm2mListObjectsPage(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test getLwm2mListObjectsPage(int, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List TbResourceController.getLwm2mListObjectsPage(int, int, String, String, String)"
  })
  void testGetLwm2mListObjectsPage() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/resource/lwm2m/page")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link TbResourceController#deleteResource(String)}.
   *
   * <p>Method under test: {@link TbResourceController#deleteResource(String)}
   */
  @Test
  @DisplayName("Test deleteResource(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceController.deleteResource(String)"})
  void testDeleteResource() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
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
   *
   * <p>Method under test: {@link TbResourceController#deleteResource(String)}
   */
  @Test
  @DisplayName("Test deleteResource(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceController.deleteResource(String)"})
  void testDeleteResource2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tbResourceController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }
}
