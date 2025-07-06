package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
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
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.dao.resource.BaseImageService;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.sql.asset.JpaAssetProfileDao;
import org.thingsboard.server.dao.sql.dashboard.JpaDashboardInfoDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceProfileDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;
import org.thingsboard.server.dao.sql.widget.JpaWidgetTypeDao;
import org.thingsboard.server.dao.sql.widget.JpaWidgetsBundleDao;
import org.thingsboard.server.dao.widget.WidgetTypeServiceImpl;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.entitiy.widgets.type.DefaultWidgetTypeService;

@ExtendWith(MockitoExtension.class)
class WidgetTypeControllerDiffblueTest {
  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  @InjectMocks private WidgetTypeController widgetTypeController;

  /**
   * Test {@link WidgetTypeController#saveWidgetType(WidgetTypeDetails, Boolean)}.
   *
   * <p>Method under test: {@link WidgetTypeController#saveWidgetType(WidgetTypeDetails, Boolean)}
   */
  @Test
  @DisplayName("Test saveWidgetType(WidgetTypeDetails, Boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "WidgetTypeDetails WidgetTypeController.saveWidgetType(WidgetTypeDetails, Boolean)"
  })
  void testSaveWidgetType() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/widgetType");
    postResult.characterEncoding("https://example.org/example");

    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setCreatedTime(1L);
    widgetTypeDetails.setDeprecated(true);
    widgetTypeDetails.setDescription("The characteristics of someone or something");
    widgetTypeDetails.setDescriptor(DoubleNode.valueOf(10.0d));
    widgetTypeDetails.setExternalId(
        new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    widgetTypeDetails.setFqn("Fqn");
    widgetTypeDetails.setId(
        new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    widgetTypeDetails.setImage("Image");
    widgetTypeDetails.setName("Name");
    widgetTypeDetails.setScada(true);
    widgetTypeDetails.setTags(new String[] {"Tags"});
    widgetTypeDetails.setTenantId(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    widgetTypeDetails.setVersion(1L);
    String content = new ObjectMapper().writeValueAsString(widgetTypeDetails);
    MockHttpServletRequestBuilder requestBuilder =
        postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(widgetTypeController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link WidgetTypeController#getWidgetTypes(int, int, String, String, String, Boolean,
   * Boolean, String, String[], Boolean)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeController#getWidgetTypes(int, int, String, String,
   * String, Boolean, Boolean, String, String[], Boolean)}
   */
  @Test
  @DisplayName(
      "Test getWidgetTypes(int, int, String, String, String, Boolean, Boolean, String, String[], Boolean); when 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData WidgetTypeController.getWidgetTypes(int, int, String, String, String, Boolean, Boolean, String, String[], Boolean)"
  })
  void testGetWidgetTypes_whenHttpsExampleOrgExample() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/widgetTypes").param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(widgetTypeController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link WidgetTypeController#getBundleWidgetTypesByBundleAlias(boolean, String)}.
   *
   * <p>Method under test: {@link WidgetTypeController#getBundleWidgetTypesByBundleAlias(boolean,
   * String)}
   */
  @Test
  @DisplayName("Test getBundleWidgetTypesByBundleAlias(boolean, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List WidgetTypeController.getBundleWidgetTypesByBundleAlias(boolean, String)"
  })
  void testGetBundleWidgetTypesByBundleAlias() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/widgetTypes")
            .param("bundleAlias", "foo")
            .param("isSystem", "https://example.org/example");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(widgetTypeController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link WidgetTypeController#getBundleWidgetTypesDetailsByBundleAlias(boolean, String)}.
   *
   * <p>Method under test: {@link
   * WidgetTypeController#getBundleWidgetTypesDetailsByBundleAlias(boolean, String)}
   */
  @Test
  @DisplayName("Test getBundleWidgetTypesDetailsByBundleAlias(boolean, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List WidgetTypeController.getBundleWidgetTypesDetailsByBundleAlias(boolean, String)"
  })
  void testGetBundleWidgetTypesDetailsByBundleAlias() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/widgetTypesDetails")
            .param("bundleAlias", "foo")
            .param("isSystem", "https://example.org/example");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(widgetTypeController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link WidgetTypeController#getBundleWidgetTypesInfosByBundleAlias(boolean, String)}.
   *
   * <p>Method under test: {@link
   * WidgetTypeController#getBundleWidgetTypesInfosByBundleAlias(boolean, String)}
   */
  @Test
  @DisplayName("Test getBundleWidgetTypesInfosByBundleAlias(boolean, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List WidgetTypeController.getBundleWidgetTypesInfosByBundleAlias(boolean, String)"
  })
  void testGetBundleWidgetTypesInfosByBundleAlias() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/widgetTypesInfos")
            .param("bundleAlias", "foo")
            .param("isSystem", "https://example.org/example");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(widgetTypeController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link WidgetTypeController#getBundleWidgetTypesInfos(String, int, int, String, String,
   * String, Boolean, String, String[])}.
   *
   * <p>Method under test: {@link WidgetTypeController#getBundleWidgetTypesInfos(String, int, int,
   * String, String, String, Boolean, String, String[])}
   */
  @Test
  @DisplayName(
      "Test getBundleWidgetTypesInfos(String, int, int, String, String, String, Boolean, String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData WidgetTypeController.getBundleWidgetTypesInfos(String, int, int, String, String, String, Boolean, String, String[])"
  })
  void testGetBundleWidgetTypesInfos() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/widgetTypesInfos")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder =
        paramResult.param("pageSize", String.valueOf(1)).param("widgetsBundleId", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(widgetTypeController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link WidgetTypeController#getWidgetTypeByBundleAliasAndTypeAlias(boolean, String,
   * String)}.
   *
   * <p>Method under test: {@link
   * WidgetTypeController#getWidgetTypeByBundleAliasAndTypeAlias(boolean, String, String)}
   */
  @Test
  @DisplayName("Test getWidgetTypeByBundleAliasAndTypeAlias(boolean, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.widget.WidgetType WidgetTypeController.getWidgetTypeByBundleAliasAndTypeAlias(boolean, String, String)"
  })
  void testGetWidgetTypeByBundleAliasAndTypeAlias() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/widgetType")
            .param("alias", "foo")
            .param("bundleAlias", "foo")
            .param("isSystem", "https://example.org/example");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(widgetTypeController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link WidgetTypeController#getWidgetType(String)}.
   *
   * <ul>
   *   <li>When {@code Fqn}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeController#getWidgetType(String)}
   */
  @Test
  @DisplayName("Test getWidgetType(String); when 'Fqn'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.widget.WidgetType WidgetTypeController.getWidgetType(String)"
  })
  void testGetWidgetType_whenFqn() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultWidgetTypeService tbWidgetTypeService =
        new DefaultWidgetTypeService(new WidgetTypeServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new WidgetTypeController(
                    tbWidgetTypeService,
                    new BaseImageService(
                        resourceDao,
                        resourceInfoDao,
                        resourceValidator,
                        assetProfileDao,
                        deviceProfileDao,
                        widgetsBundleDao,
                        widgetTypeDao,
                        new JpaDashboardInfoDao()))
                .getWidgetType("Fqn"));
  }

  /**
   * Test {@link WidgetTypeController#getWidgetType(String)}.
   *
   * <ul>
   *   <li>When {@code java.util.List}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeController#getWidgetType(String)}
   */
  @Test
  @DisplayName("Test getWidgetType(String); when 'java.util.List'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.widget.WidgetType WidgetTypeController.getWidgetType(String)"
  })
  void testGetWidgetType_whenJavaUtilList() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultWidgetTypeService tbWidgetTypeService =
        new DefaultWidgetTypeService(new WidgetTypeServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new WidgetTypeController(
                    tbWidgetTypeService,
                    new BaseImageService(
                        resourceDao,
                        resourceInfoDao,
                        resourceValidator,
                        assetProfileDao,
                        deviceProfileDao,
                        widgetsBundleDao,
                        widgetTypeDao,
                        new JpaDashboardInfoDao()))
                .getWidgetType("java.util.List"));
  }
}
