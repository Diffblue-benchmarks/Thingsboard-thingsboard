package org.thingsboard.server.dao.oauth2;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.OAuth2ClientRegistrationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientRegistrationTemplate;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {OAuth2ConfigTemplateServiceImpl.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class OAuth2ConfigTemplateServiceImplDiffblueTest {
  @MockBean
  private DataValidator<OAuth2ClientRegistrationTemplate> dataValidator;

  @MockBean
  private OAuth2ClientRegistrationTemplateDao oAuth2ClientRegistrationTemplateDao;

  @Autowired
  private OAuth2ConfigTemplateServiceImpl oAuth2ConfigTemplateServiceImpl;

  /**
   * Test {@link OAuth2ConfigTemplateServiceImpl#findAllClientRegistrationTemplates()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ConfigTemplateServiceImpl#findAllClientRegistrationTemplates()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OAuth2ConfigTemplateServiceImpl.findAllClientRegistrationTemplates()"})
  public void testFindAllClientRegistrationTemplates_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRegistrationTemplateDao.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<OAuth2ClientRegistrationTemplate> actualFindAllClientRegistrationTemplatesResult = oAuth2ConfigTemplateServiceImpl
        .findAllClientRegistrationTemplates();

    // Assert
    verify(oAuth2ClientRegistrationTemplateDao).findAll();
    assertTrue(actualFindAllClientRegistrationTemplatesResult.isEmpty());
  }

  /**
   * Test {@link OAuth2ConfigTemplateServiceImpl#findAllClientRegistrationTemplates()}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ConfigTemplateServiceImpl#findAllClientRegistrationTemplates()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OAuth2ConfigTemplateServiceImpl.findAllClientRegistrationTemplates()"})
  public void testFindAllClientRegistrationTemplates_thenThrowConstraintViolationException() {
    // Arrange
    when(oAuth2ClientRegistrationTemplateDao.findAll()).thenThrow(new ConstraintViolationException("An error occurred",
        new SQLException(), "Executing findAllClientRegistrationTemplates"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> oAuth2ConfigTemplateServiceImpl.findAllClientRegistrationTemplates());
    verify(oAuth2ClientRegistrationTemplateDao).findAll();
  }

  /**
   * Test {@link OAuth2ConfigTemplateServiceImpl#deleteClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}.
   * <p>
   * Method under test: {@link OAuth2ConfigTemplateServiceImpl#deleteClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OAuth2ConfigTemplateServiceImpl.deleteClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)"})
  public void testDeleteClientRegistrationTemplateById() {
    // Arrange
    doNothing().when(oAuth2ClientRegistrationTemplateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    oAuth2ConfigTemplateServiceImpl.deleteClientRegistrationTemplateById(
        new OAuth2ClientRegistrationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(oAuth2ClientRegistrationTemplateDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link OAuth2ConfigTemplateServiceImpl#deleteClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ConfigTemplateServiceImpl#deleteClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OAuth2ConfigTemplateServiceImpl.deleteClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)"})
  public void testDeleteClientRegistrationTemplateById_thenCallsGetId() {
    // Arrange
    doNothing().when(oAuth2ClientRegistrationTemplateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    OAuth2ClientRegistrationTemplateId templateId = mock(OAuth2ClientRegistrationTemplateId.class);
    when(templateId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    oAuth2ConfigTemplateServiceImpl.deleteClientRegistrationTemplateById(templateId);

    // Assert
    verify(templateId, atLeast(1)).getId();
    verify(oAuth2ClientRegistrationTemplateDao).removeById(isA(TenantId.class), isA(UUID.class));
  }
}
