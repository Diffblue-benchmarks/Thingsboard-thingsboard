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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {AlarmCommentDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DataValidatorDiffblueTest {
  @MockBean private ApiLimitService apiLimitService;

  @Autowired private DataValidator<AlarmComment> dataValidator;

  /**
   * Test {@link DataValidator#validate(BaseData, Function)}.
   *
   * <ul>
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validate(BaseData, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseData DataValidator.validate(BaseData, Function)"})
  public void testValidate_thenCallsApply() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();

    Function<AlarmComment, TenantId> tenantIdFunction = mock(Function.class);
    when(tenantIdFunction.apply(Mockito.<AlarmComment>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dataValidator.validate(alarmComment, tenantIdFunction));
    verify(tenantIdFunction).apply(isA(AlarmComment.class));
  }

  /**
   * Test {@link DataValidator#validate(BaseData, Function)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validate(BaseData, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseData DataValidator.validate(BaseData, Function)"})
  public void testValidate_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class, () -> dataValidator.validate(null, mock(Function.class)));
  }

  /**
   * Test {@link DataValidator#validateUpdate(TenantId, BaseData)}.
   *
   * <p>Method under test: {@link DataValidator#validateUpdate(TenantId, BaseData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseData DataValidator.validateUpdate(TenantId, BaseData)"})
  public void testValidateUpdate() {
    // Arrange, Act and Assert
    assertNull(dataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new AlarmComment()));
  }

  /**
   * Test {@link DataValidator#validateString(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateString(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateString(String, String)"})
  public void testValidateString_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class, () -> dataValidator.validateString("Exception Prefix", ""));
  }

  /**
   * Test {@link DataValidator#validateString(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateString(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateString(String, String)"})
  public void testValidateString_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dataValidator.validateString("Exception Prefix", null));
  }

  /**
   * Test {@link DataValidator#validateString(String, String)}.
   *
   * <ul>
   *   <li>When null.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateString(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateString(String, String)"})
  public void testValidateString_whenNull_thenThrowDataValidationException2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dataValidator.validateString("Exception Prefix", "\u0000"));
  }

  /**
   * Test {@link DataValidator#isSameData(BaseData, BaseData)}.
   *
   * <ul>
   *   <li>When {@link AlarmComment#AlarmComment()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#isSameData(BaseData, BaseData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataValidator.isSameData(BaseData, BaseData)"})
  public void testIsSameData_whenAlarmComment_thenReturnFalse() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();

    // Act and Assert
    assertFalse(dataValidator.isSameData(alarmComment, new AlarmComment()));
  }

  /**
   * Test {@link DataValidator#validateEmail(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateEmail(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateEmail(String)"})
  public void testValidateEmail_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> DataValidator.validateEmail(null));
  }

  /**
   * Test {@link DataValidator#doValidateEmail(String)}.
   *
   * <ul>
   *   <li>When {@code jane.doe@example.org}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#doValidateEmail(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataValidator.doValidateEmail(String)"})
  public void testDoValidateEmail_whenJaneDoeExampleOrg_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DataValidator.doValidateEmail("jane.doe@example.org"));
  }

  /**
   * Test {@link DataValidator#doValidateEmail(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#doValidateEmail(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataValidator.doValidateEmail(String)"})
  public void testDoValidateEmail_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DataValidator.doValidateEmail(null));
  }

  /**
   * Test {@link DataValidator#validateNumberOfEntitiesPerTenant(TenantId, EntityType)}.
   *
   * <p>Method under test: {@link DataValidator#validateNumberOfEntitiesPerTenant(TenantId,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateNumberOfEntitiesPerTenant(TenantId, EntityType)"})
  public void testValidateNumberOfEntitiesPerTenant() {
    // Arrange
    when(apiLimitService.checkEntitiesLimit(Mockito.<TenantId>any(), Mockito.<EntityType>any()))
        .thenReturn(true);

    // Act
    dataValidator.validateNumberOfEntitiesPerTenant(
        ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Assert
    verify(apiLimitService).checkEntitiesLimit(isA(TenantId.class), eq(EntityType.TENANT));
  }

  /**
   * Test {@link DataValidator#validateNumberOfEntitiesPerTenant(TenantId, EntityType)}.
   *
   * <ul>
   *   <li>Then throw {@link EntitiesLimitException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateNumberOfEntitiesPerTenant(TenantId,
   * EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateNumberOfEntitiesPerTenant(TenantId, EntityType)"})
  public void testValidateNumberOfEntitiesPerTenant_thenThrowEntitiesLimitException() {
    // Arrange
    when(apiLimitService.checkEntitiesLimit(Mockito.<TenantId>any(), Mockito.<EntityType>any()))
        .thenReturn(false);

    // Act and Assert
    assertThrows(
        EntitiesLimitException.class,
        () ->
            dataValidator.validateNumberOfEntitiesPerTenant(
                ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
    verify(apiLimitService).checkEntitiesLimit(isA(TenantId.class), eq(EntityType.TENANT));
  }

  /**
   * Test {@link DataValidator#validateMaxSumDataSizePerTenant(TenantId, TenantEntityWithDataDao,
   * long, long, EntityType)}.
   *
   * <p>Method under test: {@link DataValidator#validateMaxSumDataSizePerTenant(TenantId,
   * TenantEntityWithDataDao, long, long, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataValidator.validateMaxSumDataSizePerTenant(TenantId, TenantEntityWithDataDao, long, long, EntityType)"
  })
  public void testValidateMaxSumDataSizePerTenant() {
    // Arrange
    TenantEntityWithDataDao dataDao = mock(TenantEntityWithDataDao.class);
    when(dataDao.sumDataSizeByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dataValidator.validateMaxSumDataSizePerTenant(
                ModelConstants.SYSTEM_TENANT, dataDao, 3L, 3L, EntityType.TENANT));
    verify(dataDao).sumDataSizeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DataValidator#validateMaxSumDataSizePerTenant(TenantId, TenantEntityWithDataDao,
   * long, long, EntityType)}.
   *
   * <p>Method under test: {@link DataValidator#validateMaxSumDataSizePerTenant(TenantId,
   * TenantEntityWithDataDao, long, long, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataValidator.validateMaxSumDataSizePerTenant(TenantId, TenantEntityWithDataDao, long, long, EntityType)"
  })
  public void testValidateMaxSumDataSizePerTenant2() {
    // Arrange
    TenantEntityWithDataDao dataDao = mock(TenantEntityWithDataDao.class);
    when(dataDao.sumDataSizeByTenantId(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dataValidator.validateMaxSumDataSizePerTenant(
                ModelConstants.SYSTEM_TENANT, dataDao, 3L, 3L, EntityType.TENANT));
    verify(dataDao).sumDataSizeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DataValidator#validateMaxSumDataSizePerTenant(TenantId, TenantEntityWithDataDao,
   * long, long, EntityType)}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateMaxSumDataSizePerTenant(TenantId,
   * TenantEntityWithDataDao, long, long, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataValidator.validateMaxSumDataSizePerTenant(TenantId, TenantEntityWithDataDao, long, long, EntityType)"
  })
  public void testValidateMaxSumDataSizePerTenant_givenZero() {
    // Arrange
    TenantEntityWithDataDao dataDao = mock(TenantEntityWithDataDao.class);
    when(dataDao.sumDataSizeByTenantId(Mockito.<TenantId>any())).thenReturn(0L);

    // Act
    dataValidator.validateMaxSumDataSizePerTenant(
        ModelConstants.SYSTEM_TENANT, dataDao, 3L, 3L, EntityType.TENANT);

    // Assert
    verify(dataDao).sumDataSizeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DataValidator#validateMaxSumDataSizePerTenant(TenantId, TenantEntityWithDataDao,
   * long, long, EntityType)}.
   *
   * <ul>
   *   <li>Then calls {@link TbResourceRepository#sumDataSizeByTenantId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateMaxSumDataSizePerTenant(TenantId,
   * TenantEntityWithDataDao, long, long, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataValidator.validateMaxSumDataSizePerTenant(TenantId, TenantEntityWithDataDao, long, long, EntityType)"
  })
  public void testValidateMaxSumDataSizePerTenant_thenCallsSumDataSizeByTenantId() {
    // Arrange
    AlarmCommentDataValidator alarmCommentDataValidator = new AlarmCommentDataValidator();

    TbResourceRepository resourceRepository = mock(TbResourceRepository.class);
    when(resourceRepository.sumDataSizeByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            alarmCommentDataValidator.validateMaxSumDataSizePerTenant(
                ModelConstants.SYSTEM_TENANT,
                new JpaTbResourceDao(resourceRepository),
                3L,
                3L,
                EntityType.TENANT));
    verify(resourceRepository).sumDataSizeByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link DataValidator#validateJsonStructure(JsonNode, JsonNode)}.
   *
   * <ul>
   *   <li>Then calls {@link JsonNode#fieldNames()}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateJsonStructure(JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateJsonStructure(JsonNode, JsonNode)"})
  public void testValidateJsonStructure_thenCallsFieldNames() {
    // Arrange
    JsonNode expectedNode = mock(JsonNode.class);
    when(expectedNode.fieldNames()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            DataValidator.validateJsonStructure(
                expectedNode, CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
    verify(expectedNode).fieldNames();
  }

  /**
   * Test {@link DataValidator#validateJsonStructure(JsonNode, JsonNode)}.
   *
   * <ul>
   *   <li>When Instance.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateJsonStructure(JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateJsonStructure(JsonNode, JsonNode)"})
  public void testValidateJsonStructure_whenInstance_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            DataValidator.validateJsonStructure(
                CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON,
                MissingNode.getInstance()));
  }

  /**
   * Test {@link DataValidator#validateJsonStructure(JsonNode, JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateJsonStructure(JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateJsonStructure(JsonNode, JsonNode)"})
  public void testValidateJsonStructure_whenValueOfTen_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            DataValidator.validateJsonStructure(
                DoubleNode.valueOf(10.0d),
                CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link DataValidator#validateJsonStructure(JsonNode, JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateJsonStructure(JsonNode, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateJsonStructure(JsonNode, JsonNode)"})
  public void testValidateJsonStructure_whenValueOfTen_thenThrowDataValidationException2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            DataValidator.validateJsonStructure(
                CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON,
                DoubleNode.valueOf(10.0d)));
  }

  /**
   * Test {@link DataValidator#validateQueueName(String)}.
   *
   * <ul>
   *   <li>When {@code ^[a-zA-Z0-9_.\-]+$}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateQueueName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateQueueName(String)"})
  public void testValidateQueueName_whenAZAZ09_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> DataValidator.validateQueueName("^[a-zA-Z0-9_.\\-]+$"));
  }

  /**
   * Test {@link DataValidator#validateQueueName(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateQueueName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateQueueName(String)"})
  public void testValidateQueueName_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> DataValidator.validateQueueName(""));
  }

  /**
   * Test {@link DataValidator#validateQueueName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateQueueName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateQueueName(String)"})
  public void testValidateQueueName_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> DataValidator.validateQueueName(null));
  }

  /**
   * Test {@link DataValidator#validateQueueTopic(String)}.
   *
   * <ul>
   *   <li>When {@code ^[a-zA-Z0-9_.\-]+$}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateQueueTopic(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateQueueTopic(String)"})
  public void testValidateQueueTopic_whenAZAZ09_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> DataValidator.validateQueueTopic("^[a-zA-Z0-9_.\\-]+$"));
  }

  /**
   * Test {@link DataValidator#validateQueueTopic(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateQueueTopic(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateQueueTopic(String)"})
  public void testValidateQueueTopic_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> DataValidator.validateQueueTopic(""));
  }

  /**
   * Test {@link DataValidator#validateQueueTopic(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateQueueTopic(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateQueueTopic(String)"})
  public void testValidateQueueTopic_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> DataValidator.validateQueueTopic(null));
  }

  /**
   * Test {@link DataValidator#validateQueueNameOrTopic(String, String)}.
   *
   * <ul>
   *   <li>When {@code ^[a-zA-Z0-9_.\-]+$}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateQueueNameOrTopic(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateQueueNameOrTopic(String, String)"})
  public void testValidateQueueNameOrTopic_whenAZAZ09_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> DataValidator.validateQueueNameOrTopic("^[a-zA-Z0-9_.\\-]+$", "Field Name"));
  }

  /**
   * Test {@link DataValidator#validateQueueNameOrTopic(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateQueueNameOrTopic(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateQueueNameOrTopic(String, String)"})
  public void testValidateQueueNameOrTopic_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> DataValidator.validateQueueNameOrTopic("", "Field Name"));
  }

  /**
   * Test {@link DataValidator#validateQueueNameOrTopic(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidator#validateQueueNameOrTopic(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataValidator.validateQueueNameOrTopic(String, String)"})
  public void testValidateQueueNameOrTopic_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> DataValidator.validateQueueNameOrTopic(null, "Field Name"));
  }
}
