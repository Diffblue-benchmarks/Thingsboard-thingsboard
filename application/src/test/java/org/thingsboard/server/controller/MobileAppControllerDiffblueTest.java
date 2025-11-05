package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.mobile.MobileApp;
import org.thingsboard.server.dao.mobile.MobileAppServiceImpl;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.entitiy.mobile.DefaultTbMobileAppService;

@ExtendWith(MockitoExtension.class)
class MobileAppControllerDiffblueTest {
  @InjectMocks private MobileAppController mobileAppController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link MobileAppController#saveMobileApp(MobileApp, UUID[])}.
   *
   * <p>Method under test: {@link MobileAppController#saveMobileApp(MobileApp, UUID[])}
   */
  @Test
  @DisplayName("Test saveMobileApp(MobileApp, UUID[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileApp MobileAppController.saveMobileApp(MobileApp, UUID[])"})
  void testSaveMobileApp() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MobileAppController mobileAppController =
        new MobileAppController(new DefaultTbMobileAppService(new MobileAppServiceImpl()));
    MobileApp mobileApp = new MobileApp();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            mobileAppController.saveMobileApp(
                mobileApp, new UUID[] {UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")}));
  }

  /**
   * Test {@link MobileAppController#getTenantMobileAppInfos(int, int, String, String, String)}.
   *
   * <p>Method under test: {@link MobileAppController#getTenantMobileAppInfos(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test getTenantMobileAppInfos(int, int, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData MobileAppController.getTenantMobileAppInfos(int, int, String, String, String)"
  })
  void testGetTenantMobileAppInfos() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new MobileAppController(new DefaultTbMobileAppService(new MobileAppServiceImpl()))
                .getTenantMobileAppInfos(3, 1, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link MobileAppController#getMobileAppInfoById(UUID)}.
   *
   * <p>Method under test: {@link MobileAppController#getMobileAppInfoById(UUID)}
   */
  @Test
  @DisplayName("Test getMobileAppInfoById(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileAppInfo MobileAppController.getMobileAppInfoById(UUID)"})
  void testGetMobileAppInfoById() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/mobileApp/info/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileAppController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link MobileAppController#deleteMobileApp(UUID)}.
   *
   * <p>Method under test: {@link MobileAppController#deleteMobileApp(UUID)}
   */
  @Test
  @DisplayName("Test deleteMobileApp(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppController.deleteMobileApp(UUID)"})
  void testDeleteMobileApp() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/mobileApp/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(mobileAppController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }
}
