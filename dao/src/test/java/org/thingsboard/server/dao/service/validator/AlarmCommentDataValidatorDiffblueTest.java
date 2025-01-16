package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {AlarmCommentDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class AlarmCommentDataValidatorDiffblueTest {
  @Autowired
  private AlarmCommentDataValidator alarmCommentDataValidator;

  @MockBean
  private ApiLimitService apiLimitService;

  /**
   * Test
   * {@link AlarmCommentDataValidator#validateDataImpl(TenantId, AlarmComment)}
   * with {@code TenantId}, {@code AlarmComment}.
   * <p>
   * Method under test:
   * {@link AlarmCommentDataValidator#validateDataImpl(TenantId, AlarmComment)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAlarmComment() {
    // Arrange
    AlarmComment alarmComment = mock(AlarmComment.class);
    when(alarmComment.getAlarmId()).thenThrow(new DataValidationException("An error occurred"));
    when(alarmComment.getComment()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> alarmCommentDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, alarmComment));
    verify(alarmComment).getAlarmId();
    verify(alarmComment).getComment();
  }

  /**
   * Test
   * {@link AlarmCommentDataValidator#validateDataImpl(TenantId, AlarmComment)}
   * with {@code TenantId}, {@code AlarmComment}.
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmCommentDataValidator#validateDataImpl(TenantId, AlarmComment)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAlarmComment_givenAlarmIdWithIdIsNull_uuid() {
    // Arrange
    AlarmComment alarmComment = mock(AlarmComment.class);
    when(alarmComment.getAlarmId()).thenReturn(new AlarmId(ModelConstants.NULL_UUID));
    when(alarmComment.getComment()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act
    alarmCommentDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, alarmComment);

    // Assert that nothing has changed
    verify(alarmComment).getAlarmId();
    verify(alarmComment).getComment();
  }

  /**
   * Test
   * {@link AlarmCommentDataValidator#validateDataImpl(TenantId, AlarmComment)}
   * with {@code TenantId}, {@code AlarmComment}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmCommentDataValidator#validateDataImpl(TenantId, AlarmComment)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAlarmComment_givenNull() {
    // Arrange
    AlarmComment alarmComment = mock(AlarmComment.class);
    when(alarmComment.getAlarmId()).thenReturn(null);
    when(alarmComment.getComment()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> alarmCommentDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, alarmComment));
    verify(alarmComment).getAlarmId();
    verify(alarmComment).getComment();
  }

  /**
   * Test
   * {@link AlarmCommentDataValidator#validateDataImpl(TenantId, AlarmComment)}
   * with {@code TenantId}, {@code AlarmComment}.
   * <ul>
   *   <li>When {@link AlarmComment#AlarmComment()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmCommentDataValidator#validateDataImpl(TenantId, AlarmComment)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAlarmComment_whenAlarmComment() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> alarmCommentDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new AlarmComment()));
  }
}
