package org.thingsboard.server.service.security.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.oauth2.MapperType;

class OAuth2ClientMapperProviderDiffblueTest {
  /**
   * Test {@link OAuth2ClientMapperProvider#getOAuth2ClientMapperByType(MapperType)}.
   * <ul>
   *   <li>When {@code APPLE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientMapperProvider#getOAuth2ClientMapperByType(MapperType)}
   */
  @Test
  @DisplayName("Test getOAuth2ClientMapperByType(MapperType); when 'APPLE'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.service.security.auth.oauth2.OAuth2ClientMapper OAuth2ClientMapperProvider.getOAuth2ClientMapperByType(MapperType)"})
  void testGetOAuth2ClientMapperByType_whenApple_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OAuth2ClientMapperProvider()).getOAuth2ClientMapperByType(MapperType.APPLE));
  }

  /**
   * Test {@link OAuth2ClientMapperProvider#getOAuth2ClientMapperByType(MapperType)}.
   * <ul>
   *   <li>When {@code BASIC}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientMapperProvider#getOAuth2ClientMapperByType(MapperType)}
   */
  @Test
  @DisplayName("Test getOAuth2ClientMapperByType(MapperType); when 'BASIC'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.service.security.auth.oauth2.OAuth2ClientMapper OAuth2ClientMapperProvider.getOAuth2ClientMapperByType(MapperType)"})
  void testGetOAuth2ClientMapperByType_whenBasic_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OAuth2ClientMapperProvider()).getOAuth2ClientMapperByType(MapperType.BASIC));
  }

  /**
   * Test {@link OAuth2ClientMapperProvider#getOAuth2ClientMapperByType(MapperType)}.
   * <ul>
   *   <li>When {@code CUSTOM}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientMapperProvider#getOAuth2ClientMapperByType(MapperType)}
   */
  @Test
  @DisplayName("Test getOAuth2ClientMapperByType(MapperType); when 'CUSTOM'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.service.security.auth.oauth2.OAuth2ClientMapper OAuth2ClientMapperProvider.getOAuth2ClientMapperByType(MapperType)"})
  void testGetOAuth2ClientMapperByType_whenCustom_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OAuth2ClientMapperProvider()).getOAuth2ClientMapperByType(MapperType.CUSTOM));
  }

  /**
   * Test {@link OAuth2ClientMapperProvider#getOAuth2ClientMapperByType(MapperType)}.
   * <ul>
   *   <li>When {@code GITHUB}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientMapperProvider#getOAuth2ClientMapperByType(MapperType)}
   */
  @Test
  @DisplayName("Test getOAuth2ClientMapperByType(MapperType); when 'GITHUB'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.service.security.auth.oauth2.OAuth2ClientMapper OAuth2ClientMapperProvider.getOAuth2ClientMapperByType(MapperType)"})
  void testGetOAuth2ClientMapperByType_whenGithub_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OAuth2ClientMapperProvider()).getOAuth2ClientMapperByType(MapperType.GITHUB));
  }
}
