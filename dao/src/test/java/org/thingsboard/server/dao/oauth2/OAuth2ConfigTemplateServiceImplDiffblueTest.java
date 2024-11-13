package org.thingsboard.server.dao.oauth2;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.OAuth2ClientRegistrationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientRegistrationTemplate;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {OAuth2ConfigTemplateServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class OAuth2ConfigTemplateServiceImplDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DataValidator<OAuth2ClientRegistrationTemplate> dataValidator;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private OAuth2ClientRegistrationTemplateDao oAuth2ClientRegistrationTemplateDao;

  @Autowired
  private OAuth2ConfigTemplateServiceImpl oAuth2ConfigTemplateServiceImpl;

  @MockBean
  private RelationService relationService;

  /**
   * Test
   * {@link OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   * <ul>
   *   <li>Then return
   * {@link OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  public void testSaveClientRegistrationTemplate_thenReturnOAuth2ClientRegistrationTemplate() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    when(oAuth2ClientRegistrationTemplateDao.save(Mockito.<TenantId>any(),
        Mockito.<OAuth2ClientRegistrationTemplate>any())).thenReturn(oAuth2ClientRegistrationTemplate);
    when(dataValidator.validate(Mockito.<OAuth2ClientRegistrationTemplate>any(),
        Mockito.<Function<OAuth2ClientRegistrationTemplate, TenantId>>any()))
        .thenReturn(new OAuth2ClientRegistrationTemplate());

    // Act
    OAuth2ClientRegistrationTemplate actualSaveClientRegistrationTemplateResult = oAuth2ConfigTemplateServiceImpl
        .saveClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate());

    // Assert
    verify(oAuth2ClientRegistrationTemplateDao).save(isA(TenantId.class), isA(OAuth2ClientRegistrationTemplate.class));
    verify(dataValidator).validate(isA(OAuth2ClientRegistrationTemplate.class), isA(Function.class));
    assertSame(oAuth2ClientRegistrationTemplate, actualSaveClientRegistrationTemplateResult);
  }

  /**
   * Test
   * {@link OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  public void testSaveClientRegistrationTemplate_thenThrowConstraintViolationException() {
    // Arrange
    when(dataValidator.validate(Mockito.<OAuth2ClientRegistrationTemplate>any(),
        Mockito.<Function<OAuth2ClientRegistrationTemplate, TenantId>>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
            "Executing saveClientRegistrationTemplate [{}]"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> oAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate()));
    verify(dataValidator).validate(isA(OAuth2ClientRegistrationTemplate.class), isA(Function.class));
  }

  /**
   * Test
   * {@link OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateByProviderId(String)}.
   * <p>
   * Method under test:
   * {@link OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateByProviderId(String)}
   */
  @Test
  public void testFindClientRegistrationTemplateByProviderId() {
    // Arrange
    Optional<OAuth2ClientRegistrationTemplate> ofResult = Optional.of(new OAuth2ClientRegistrationTemplate());
    when(oAuth2ClientRegistrationTemplateDao.findByProviderId(Mockito.<String>any())).thenReturn(ofResult);

    // Act
    Optional<OAuth2ClientRegistrationTemplate> actualFindClientRegistrationTemplateByProviderIdResult = oAuth2ConfigTemplateServiceImpl
        .findClientRegistrationTemplateByProviderId("42");

    // Assert
    verify(oAuth2ClientRegistrationTemplateDao).findByProviderId(eq("42"));
    assertSame(ofResult, actualFindClientRegistrationTemplateByProviderIdResult);
  }

  /**
   * Test
   * {@link OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateByProviderId(String)}.
   * <p>
   * Method under test:
   * {@link OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateByProviderId(String)}
   */
  @Test
  public void testFindClientRegistrationTemplateByProviderId2() {
    // Arrange
    when(oAuth2ClientRegistrationTemplateDao.findByProviderId(Mockito.<String>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
            "Executing findClientRegistrationTemplateByProviderId [{}]"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> oAuth2ConfigTemplateServiceImpl.findClientRegistrationTemplateByProviderId("42"));
    verify(oAuth2ClientRegistrationTemplateDao).findByProviderId(eq("42"));
  }

  /**
   * Test
   * {@link OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}.
   * <p>
   * Method under test:
   * {@link OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}
   */
  @Test
  public void testFindClientRegistrationTemplateById() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    when(oAuth2ClientRegistrationTemplateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(oAuth2ClientRegistrationTemplate);

    // Act
    OAuth2ClientRegistrationTemplate actualFindClientRegistrationTemplateByIdResult = oAuth2ConfigTemplateServiceImpl
        .findClientRegistrationTemplateById(new OAuth2ClientRegistrationTemplateId(ModelConstants.NULL_UUID));

    // Assert
    verify(oAuth2ClientRegistrationTemplateDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(oAuth2ClientRegistrationTemplate, actualFindClientRegistrationTemplateByIdResult);
  }

  /**
   * Test
   * {@link OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}
   */
  @Test
  public void testFindClientRegistrationTemplateById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    when(oAuth2ClientRegistrationTemplateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(oAuth2ClientRegistrationTemplate);
    OAuth2ClientRegistrationTemplateId templateId = mock(OAuth2ClientRegistrationTemplateId.class);
    when(templateId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    OAuth2ClientRegistrationTemplate actualFindClientRegistrationTemplateByIdResult = oAuth2ConfigTemplateServiceImpl
        .findClientRegistrationTemplateById(templateId);

    // Assert
    verify(templateId, atLeast(1)).getId();
    verify(oAuth2ClientRegistrationTemplateDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(oAuth2ClientRegistrationTemplate, actualFindClientRegistrationTemplateByIdResult);
  }

  /**
   * Test
   * {@link OAuth2ConfigTemplateServiceImpl#findAllClientRegistrationTemplates()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ConfigTemplateServiceImpl#findAllClientRegistrationTemplates()}
   */
  @Test
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
   * Test
   * {@link OAuth2ConfigTemplateServiceImpl#findAllClientRegistrationTemplates()}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ConfigTemplateServiceImpl#findAllClientRegistrationTemplates()}
   */
  @Test
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
   * Test
   * {@link OAuth2ConfigTemplateServiceImpl#deleteClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}.
   * <p>
   * Method under test:
   * {@link OAuth2ConfigTemplateServiceImpl#deleteClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}
   */
  @Test
  public void testDeleteClientRegistrationTemplateById() {
    // Arrange
    doNothing().when(oAuth2ClientRegistrationTemplateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    oAuth2ConfigTemplateServiceImpl
        .deleteClientRegistrationTemplateById(new OAuth2ClientRegistrationTemplateId(ModelConstants.NULL_UUID));

    // Assert that nothing has changed
    verify(oAuth2ClientRegistrationTemplateDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link OAuth2ConfigTemplateServiceImpl#deleteClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ConfigTemplateServiceImpl#deleteClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}
   */
  @Test
  public void testDeleteClientRegistrationTemplateById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(oAuth2ClientRegistrationTemplateDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    OAuth2ClientRegistrationTemplateId templateId = mock(OAuth2ClientRegistrationTemplateId.class);
    when(templateId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    oAuth2ConfigTemplateServiceImpl.deleteClientRegistrationTemplateById(templateId);

    // Assert that nothing has changed
    verify(templateId, atLeast(1)).getId();
    verify(oAuth2ClientRegistrationTemplateDao).removeById(isA(TenantId.class), isA(UUID.class));
  }
}
