package org.thingsboard.server.dao.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.ArrayList;
import java.util.function.Function;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.BaseData;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.TenantEntityWithDataDao;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.exception.EntitiesLimitException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.validator.AlarmCommentDataValidator;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {AlarmCommentDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class DataValidatorDiffblueTest {
  @Autowired
  private DataValidator<AlarmComment> dataValidator;

  @MockBean
  private ApiLimitService apiLimitService;

  /**
   * Test {@link DataValidator#validate(BaseData, Function)}.
   * <ul>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#validate(BaseData, Function)}
   */
  @Test
  public void testValidate_thenCallsApply() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();
    Function<AlarmComment, TenantId> tenantIdFunction = mock(Function.class);
    when(tenantIdFunction.apply(Mockito.<AlarmComment>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> dataValidator.validate(alarmComment, tenantIdFunction));
    verify(tenantIdFunction).apply(isA(AlarmComment.class));
  }

  /**
   * Test {@link DataValidator#validate(BaseData, Function)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#validate(BaseData, Function)}
   */
  @Test
  public void testValidate_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> dataValidator.validate(null, mock(Function.class)));
  }

  /**
   * Test {@link DataValidator#validateUpdate(TenantId, BaseData)}.
   * <ul>
   *   <li>When {@link AlarmComment#AlarmComment()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#validateUpdate(TenantId, BaseData)}
   */
  @Test
  public void testValidateUpdate_whenAlarmComment() {
    // Arrange, Act and Assert
    assertNull(dataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new AlarmComment()));
    assertNull(dataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, mock(AlarmComment.class)));
  }

  /**
   * Test {@link DataValidator#validateString(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#validateString(String, String)}
   */
  @Test
  public void testValidateString_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> dataValidator.validateString("Exception Prefix", ""));
  }

  /**
   * Test {@link DataValidator#validateString(String, String)}.
   * <ul>
   *   <li>When null.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#validateString(String, String)}
   */
  @Test
  public void testValidateString_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> dataValidator.validateString("Exception Prefix", "\u0000"));
  }

  /**
   * Test {@link DataValidator#isSameData(BaseData, BaseData)}.
   * <ul>
   *   <li>When {@link AlarmComment#AlarmComment()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#isSameData(BaseData, BaseData)}
   */
  @Test
  public void testIsSameData_whenAlarmComment_thenReturnFalse() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();

    // Act and Assert
    assertFalse(dataValidator.isSameData(alarmComment, new AlarmComment()));
  }

  /**
   * Test {@link DataValidator#isSameData(BaseData, BaseData)}.
   * <ul>
   *   <li>When {@link AlarmComment}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#isSameData(BaseData, BaseData)}
   */
  @Test
  public void testIsSameData_whenAlarmComment_thenReturnFalse2() {
    // Arrange
    AlarmComment alarmComment = mock(AlarmComment.class);

    // Act and Assert
    assertFalse(dataValidator.isSameData(alarmComment, new AlarmComment()));
  }

  /**
   * Test {@link DataValidator#validateEmail(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#validateEmail(String)}
   */
  @Test
  public void testValidateEmail_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> DataValidator.validateEmail(null));
  }

  /**
   * Test {@link DataValidator#validateEmail(String)}.
   * <ul>
   *   <li>When {@code U@U.U}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#validateEmail(String)}
   */
  @Test
  public void testValidateEmail_whenUUU_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> DataValidator.validateEmail("U@U.U"));
  }

  /**
   * Test {@link DataValidator#doValidateEmail(String)}.
   * <ul>
   *   <li>When {@code jane.doe@example.org}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#doValidateEmail(String)}
   */
  @Test
  public void testDoValidateEmail_whenJaneDoeExampleOrg_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DataValidator.doValidateEmail("jane.doe@example.org"));
  }

  /**
   * Test {@link DataValidator#doValidateEmail(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#doValidateEmail(String)}
   */
  @Test
  public void testDoValidateEmail_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DataValidator.doValidateEmail(null));
  }

  /**
   * Test {@link DataValidator#doValidateEmail(String)}.
   * <ul>
   *   <li>When {@code U@U.U}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#doValidateEmail(String)}
   */
  @Test
  public void testDoValidateEmail_whenUUU_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DataValidator.doValidateEmail("U@U.U"));
  }

  /**
   * Test
   * {@link DataValidator#validateNumberOfEntitiesPerTenant(TenantId, EntityType)}.
   * <p>
   * Method under test:
   * {@link DataValidator#validateNumberOfEntitiesPerTenant(TenantId, EntityType)}
   */
  @Test
  public void testValidateNumberOfEntitiesPerTenant() {
    // Arrange
    when(apiLimitService.checkEntitiesLimit(Mockito.<TenantId>any(), Mockito.<EntityType>any())).thenReturn(true);

    // Act
    dataValidator.validateNumberOfEntitiesPerTenant(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Assert
    verify(apiLimitService).checkEntitiesLimit(isA(TenantId.class), eq(EntityType.TENANT));
  }

  /**
   * Test
   * {@link DataValidator#validateNumberOfEntitiesPerTenant(TenantId, EntityType)}.
   * <ul>
   *   <li>Then throw {@link EntitiesLimitException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataValidator#validateNumberOfEntitiesPerTenant(TenantId, EntityType)}
   */
  @Test
  public void testValidateNumberOfEntitiesPerTenant_thenThrowEntitiesLimitException() {
    // Arrange
    when(apiLimitService.checkEntitiesLimit(Mockito.<TenantId>any(), Mockito.<EntityType>any())).thenReturn(false);

    // Act and Assert
    assertThrows(EntitiesLimitException.class,
        () -> dataValidator.validateNumberOfEntitiesPerTenant(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
    verify(apiLimitService).checkEntitiesLimit(isA(TenantId.class), eq(EntityType.TENANT));
  }

  /**
   * Test
   * {@link DataValidator#validateMaxSumDataSizePerTenant(TenantId, TenantEntityWithDataDao, long, long, EntityType)}.
   * <p>
   * Method under test:
   * {@link DataValidator#validateMaxSumDataSizePerTenant(TenantId, TenantEntityWithDataDao, long, long, EntityType)}
   */
  @Test
  public void testValidateMaxSumDataSizePerTenant() {
    // Arrange
    TenantEntityWithDataDao dataDao = mock(TenantEntityWithDataDao.class);
    when(dataDao.sumDataSizeByTenantId(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> dataValidator
        .validateMaxSumDataSizePerTenant(ModelConstants.SYSTEM_TENANT, dataDao, 3L, 3L, EntityType.TENANT));
    verify(dataDao).sumDataSizeByTenantId(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DataValidator#validateMaxSumDataSizePerTenant(TenantId, TenantEntityWithDataDao, long, long, EntityType)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataValidator#validateMaxSumDataSizePerTenant(TenantId, TenantEntityWithDataDao, long, long, EntityType)}
   */
  @Test
  public void testValidateMaxSumDataSizePerTenant_givenOne_thenThrowDataValidationException() {
    // Arrange
    TenantEntityWithDataDao dataDao = mock(TenantEntityWithDataDao.class);
    when(dataDao.sumDataSizeByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> dataValidator
        .validateMaxSumDataSizePerTenant(ModelConstants.SYSTEM_TENANT, dataDao, 3L, 3L, EntityType.TENANT));
    verify(dataDao).sumDataSizeByTenantId(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DataValidator#validateMaxSumDataSizePerTenant(TenantId, TenantEntityWithDataDao, long, long, EntityType)}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataValidator#validateMaxSumDataSizePerTenant(TenantId, TenantEntityWithDataDao, long, long, EntityType)}
   */
  @Test
  public void testValidateMaxSumDataSizePerTenant_givenZero() {
    // Arrange
    TenantEntityWithDataDao dataDao = mock(TenantEntityWithDataDao.class);
    when(dataDao.sumDataSizeByTenantId(Mockito.<TenantId>any())).thenReturn(0L);

    // Act
    dataValidator.validateMaxSumDataSizePerTenant(ModelConstants.SYSTEM_TENANT, dataDao, 3L, 3L, EntityType.TENANT);

    // Assert
    verify(dataDao).sumDataSizeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DataValidator#validateJsonStructure(JsonNode, JsonNode)}.
   * <p>
   * Method under test:
   * {@link DataValidator#validateJsonStructure(JsonNode, JsonNode)}
   */
  @Test
  public void testValidateJsonStructure() {
    // Arrange
    JsonNode expectedNode = mock(JsonNode.class);

    ArrayList<String> stringList = new ArrayList<>();
    when(expectedNode.fieldNames()).thenReturn(stringList.iterator());
    JsonNode actualNode = mock(JsonNode.class);
    when(actualNode.fieldNames()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> DataValidator.validateJsonStructure(expectedNode, actualNode));
    verify(expectedNode).fieldNames();
    verify(actualNode).fieldNames();
  }

  /**
   * Test {@link DataValidator#validateJsonStructure(JsonNode, JsonNode)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then calls {@link JsonNode#fieldNames()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataValidator#validateJsonStructure(JsonNode, JsonNode)}
   */
  @Test
  public void testValidateJsonStructure_givenArrayListAdd42_thenCallsFieldNames() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    JsonNode expectedNode = mock(JsonNode.class);
    when(expectedNode.fieldNames()).thenReturn(stringList.iterator());
    JsonNode actualNode = mock(JsonNode.class);

    ArrayList<String> stringList2 = new ArrayList<>();
    when(actualNode.fieldNames()).thenReturn(stringList2.iterator());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> DataValidator.validateJsonStructure(expectedNode, actualNode));
    verify(expectedNode).fieldNames();
    verify(actualNode).fieldNames();
  }

  /**
   * Test {@link DataValidator#validateJsonStructure(JsonNode, JsonNode)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link JsonNode#fieldNames()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataValidator#validateJsonStructure(JsonNode, JsonNode)}
   */
  @Test
  public void testValidateJsonStructure_givenArrayListIterator_thenCallsFieldNames() {
    // Arrange
    JsonNode expectedNode = mock(JsonNode.class);

    ArrayList<String> stringList = new ArrayList<>();
    when(expectedNode.fieldNames()).thenReturn(stringList.iterator());

    // Act
    DataValidator.validateJsonStructure(expectedNode, MissingNode.getInstance());

    // Assert that nothing has changed
    verify(expectedNode).fieldNames();
  }

  /**
   * Test {@link DataValidator#validateJsonStructure(JsonNode, JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataValidator#validateJsonStructure(JsonNode, JsonNode)}
   */
  @Test
  public void testValidateJsonStructure_whenInstance_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> DataValidator.validateJsonStructure(MissingNode.getInstance(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
    assertThrows(DataValidationException.class, () -> DataValidator.validateJsonStructure(NullNode.getInstance(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link DataValidator#validateQueueName(String)}.
   * <ul>
   *   <li>When {@code ^[a-zA-Z0-9_.\-]+$}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#validateQueueName(String)}
   */
  @Test
  public void testValidateQueueName_whenAZAZ09_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> DataValidator.validateQueueName("^[a-zA-Z0-9_.\\-]+$"));
  }

  /**
   * Test {@link DataValidator#validateQueueName(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#validateQueueName(String)}
   */
  @Test
  public void testValidateQueueName_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> DataValidator.validateQueueName(""));
  }

  /**
   * Test {@link DataValidator#validateQueueTopic(String)}.
   * <ul>
   *   <li>When {@code ^[a-zA-Z0-9_.\-]+$}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#validateQueueTopic(String)}
   */
  @Test
  public void testValidateQueueTopic_whenAZAZ09_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> DataValidator.validateQueueTopic("^[a-zA-Z0-9_.\\-]+$"));
  }

  /**
   * Test {@link DataValidator#validateQueueTopic(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#validateQueueTopic(String)}
   */
  @Test
  public void testValidateQueueTopic_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> DataValidator.validateQueueTopic(""));
  }

  /**
   * Test {@link DataValidator#validateQueueNameOrTopic(String, String)}.
   * <ul>
   *   <li>When {@code ^[a-zA-Z0-9_.\-]+$}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataValidator#validateQueueNameOrTopic(String, String)}
   */
  @Test
  public void testValidateQueueNameOrTopic_whenAZAZ09_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> DataValidator.validateQueueNameOrTopic("^[a-zA-Z0-9_.\\-]+$", "Field Name"));
  }

  /**
   * Test {@link DataValidator#validateQueueNameOrTopic(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataValidator#validateQueueNameOrTopic(String, String)}
   */
  @Test
  public void testValidateQueueNameOrTopic_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> DataValidator.validateQueueNameOrTopic("", "Field Name"));
  }
}
