package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {ApiUsageDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class ApiUsageDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @Autowired
  private ApiUsageDataValidator apiUsageDataValidator;

  @MockBean
  private TenantService tenantService;

  /**
   * Test {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   * with {@code TenantId}, {@code ApiUsageState}.
   * <p>
   * Method under test:
   * {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   */
  @Test
  public void testValidateDataImplWithTenantIdApiUsageState() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getEntityId()).thenThrow(new DataValidationException("An error occurred"));
    when(apiUsageState.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> apiUsageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, apiUsageState));
    verify(apiUsageState).getEntityId();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   * with {@code TenantId}, {@code ApiUsageState}.
   * <p>
   * Method under test:
   * {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   */
  @Test
  public void testValidateDataImplWithTenantIdApiUsageState2() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(apiUsageState.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    apiUsageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, apiUsageState);

    // Assert
    verify(apiUsageState, atLeast(1)).getEntityId();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   * with {@code TenantId}, {@code ApiUsageState}.
   * <p>
   * Method under test:
   * {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   */
  @Test
  public void testValidateDataImplWithTenantIdApiUsageState3() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getEntityId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(apiUsageState.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    apiUsageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, apiUsageState);

    // Assert
    verify(apiUsageState, atLeast(1)).getEntityId();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   * with {@code TenantId}, {@code ApiUsageState}.
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   */
  @Test
  public void testValidateDataImplWithTenantIdApiUsageState_givenAlarmIdWithIdIsNull_uuid() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getEntityId()).thenReturn(new AlarmId(ModelConstants.NULL_UUID));
    when(apiUsageState.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> apiUsageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, apiUsageState));
    verify(apiUsageState, atLeast(1)).getEntityId();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   * with {@code TenantId}, {@code ApiUsageState}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   */
  @Test
  public void testValidateDataImplWithTenantIdApiUsageState_givenNull() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getEntityId()).thenReturn(null);
    when(apiUsageState.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> apiUsageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, apiUsageState));
    verify(apiUsageState).getEntityId();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   * with {@code TenantId}, {@code ApiUsageState}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   */
  @Test
  public void testValidateDataImplWithTenantIdApiUsageState_givenNull_customer_id() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(apiUsageState.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    apiUsageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, apiUsageState);

    // Assert
    verify(apiUsageState, atLeast(1)).getEntityId();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   * with {@code TenantId}, {@code ApiUsageState}.
   * <ul>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   */
  @Test
  public void testValidateDataImplWithTenantIdApiUsageState_thenCallsGetEntityType() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new DataValidationException("An error occurred"));
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getEntityId()).thenReturn(alarmId);
    when(apiUsageState.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> apiUsageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, apiUsageState));
    verify(apiUsageState, atLeast(1)).getEntityId();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(alarmId).getEntityType();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   * with {@code TenantId}, {@code ApiUsageState}.
   * <ul>
   *   <li>When {@link ApiUsageState#ApiUsageState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   */
  @Test
  public void testValidateDataImplWithTenantIdApiUsageState_whenApiUsageState() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> apiUsageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new ApiUsageState()));
  }
}
