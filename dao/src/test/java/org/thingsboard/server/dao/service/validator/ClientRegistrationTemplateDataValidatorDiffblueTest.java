/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientRegistrationTemplate;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {ClientRegistrationTemplateDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ClientRegistrationTemplateDataValidatorDiffblueTest {
  @Autowired
  private ClientRegistrationTemplateDataValidator clientRegistrationTemplateDataValidator;

  /**
   * Test {@link ClientRegistrationTemplateDataValidator#validateUpdate(TenantId,
   * OAuth2ClientRegistrationTemplate)} with {@code TenantId}, {@code
   * OAuth2ClientRegistrationTemplate}.
   *
   * <p>Method under test: {@link ClientRegistrationTemplateDataValidator#validateUpdate(TenantId,
   * OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2ClientRegistrationTemplate ClientRegistrationTemplateDataValidator.validateUpdate(TenantId, OAuth2ClientRegistrationTemplate)"
  })
  public void testValidateUpdateWithTenantIdOAuth2ClientRegistrationTemplate() {
    // Arrange, Act and Assert
    assertNull(
        clientRegistrationTemplateDataValidator.validateUpdate(
            ModelConstants.SYSTEM_TENANT, new OAuth2ClientRegistrationTemplate()));
  }

  /**
   * Test {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)} with {@code TenantId}, {@code
   * OAuth2ClientRegistrationTemplate}.
   *
   * <p>Method under test: {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClientRegistrationTemplateDataValidator.validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)"
  })
  public void testValidateDataImplWithTenantIdOAuth2ClientRegistrationTemplate() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            clientRegistrationTemplateDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new OAuth2ClientRegistrationTemplate()));
  }

  /**
   * Test {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)} with {@code TenantId}, {@code
   * OAuth2ClientRegistrationTemplate}.
   *
   * <p>Method under test: {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClientRegistrationTemplateDataValidator.validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)"
  })
  public void testValidateDataImplWithTenantIdOAuth2ClientRegistrationTemplate2() {
    // Arrange
    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate());
    clientRegistrationTemplate.setProviderId("");
    clientRegistrationTemplate.setMapperConfig(mock(OAuth2MapperConfig.class));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            clientRegistrationTemplateDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, clientRegistrationTemplate));
  }
}
