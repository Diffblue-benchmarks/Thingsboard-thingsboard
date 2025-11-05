package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.oauth2.OAuth2ClientServiceImpl;
import org.thingsboard.server.dao.oauth2.OAuth2Configuration;
import org.thingsboard.server.service.entitiy.oauth2client.DefaultTbOauth2ClientService;

class OAuth2ControllerDiffblueTest {
  /**
   * Test {@link OAuth2Controller#findTenantOAuth2ClientInfos(int, int, String, String, String)}.
   *
   * <p>Method under test: {@link OAuth2Controller#findTenantOAuth2ClientInfos(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test findTenantOAuth2ClientInfos(int, int, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData OAuth2Controller.findTenantOAuth2ClientInfos(int, int, String, String, String)"
  })
  void testFindTenantOAuth2ClientInfos() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    OAuth2Configuration oAuth2Configuration = new OAuth2Configuration();
    OAuth2Controller oAuth2Controller =
        new OAuth2Controller(
            oAuth2Configuration, new DefaultTbOauth2ClientService(new OAuth2ClientServiceImpl()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            oAuth2Controller.findTenantOAuth2ClientInfos(
                3, 1, "Text Search", "Sort Property", "asc"));
  }
}
