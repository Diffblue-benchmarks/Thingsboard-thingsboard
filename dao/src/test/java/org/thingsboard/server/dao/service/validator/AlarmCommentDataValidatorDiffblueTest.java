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

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {AlarmCommentDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AlarmCommentDataValidatorDiffblueTest {
  @Autowired private AlarmCommentDataValidator alarmCommentDataValidator;

  /**
   * Test {@link AlarmCommentDataValidator#validateDataImpl(TenantId, AlarmComment)} with {@code
   * TenantId}, {@code AlarmComment}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentDataValidator#validateDataImpl(TenantId,
   * AlarmComment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmCommentDataValidator.validateDataImpl(TenantId, AlarmComment)"})
  public void testValidateDataImplWithTenantIdAlarmComment_givenNull() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment(new AlarmComment());
    alarmComment.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmComment.setAlarmId(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            alarmCommentDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, alarmComment));
  }

  /**
   * Test {@link AlarmCommentDataValidator#validateDataImpl(TenantId, AlarmComment)} with {@code
   * TenantId}, {@code AlarmComment}.
   *
   * <ul>
   *   <li>When {@link AlarmComment#AlarmComment()}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentDataValidator#validateDataImpl(TenantId,
   * AlarmComment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmCommentDataValidator.validateDataImpl(TenantId, AlarmComment)"})
  public void testValidateDataImplWithTenantIdAlarmComment_whenAlarmComment() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            alarmCommentDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new AlarmComment()));
  }
}
