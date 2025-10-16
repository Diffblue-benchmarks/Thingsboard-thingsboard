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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.event.Event;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {EventDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EventDataValidatorDiffblueTest {
  @Autowired private EventDataValidator eventDataValidator;

  /**
   * Test {@link EventDataValidator#validateDataImpl(TenantId, Event)} with {@code TenantId}, {@code
   * Event}.
   *
   * <p>Method under test: {@link EventDataValidator#validateDataImpl(TenantId, Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventDataValidator.validateDataImpl(TenantId, Event)"})
  public void testValidateDataImplWithTenantIdEvent() {
    // Arrange
    Event event = mock(Event.class);
    when(event.getEntityId()).thenThrow(new DataValidationException("An error occurred"));
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> eventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, event));
    verify(event).getEntityId();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EventDataValidator#validateDataImpl(TenantId, Event)} with {@code TenantId}, {@code
   * Event}.
   *
   * <p>Method under test: {@link EventDataValidator#validateDataImpl(TenantId, Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventDataValidator.validateDataImpl(TenantId, Event)"})
  public void testValidateDataImplWithTenantIdEvent2() {
    // Arrange
    Event event = mock(Event.class);
    when(event.getServiceId()).thenThrow(new DataValidationException("An error occurred"));
    when(event.getEntityId()).thenReturn(ModelConstants.NULL_UUID);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> eventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, event));
    verify(event).getEntityId();
    verify(event).getServiceId();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EventDataValidator#validateDataImpl(TenantId, Event)} with {@code TenantId}, {@code
   * Event}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link EventDataValidator#validateDataImpl(TenantId, Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventDataValidator.validateDataImpl(TenantId, Event)"})
  public void testValidateDataImplWithTenantIdEvent_givenEmptyString() {
    // Arrange
    Event event = mock(Event.class);
    when(event.getServiceId()).thenReturn("");
    when(event.getEntityId()).thenReturn(ModelConstants.NULL_UUID);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> eventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, event));
    verify(event).getEntityId();
    verify(event).getServiceId();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EventDataValidator#validateDataImpl(TenantId, Event)} with {@code TenantId}, {@code
   * Event}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Event} {@link Event#getEntityId()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EventDataValidator#validateDataImpl(TenantId, Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventDataValidator.validateDataImpl(TenantId, Event)"})
  public void testValidateDataImplWithTenantIdEvent_givenNull_whenEventGetEntityIdReturnNull() {
    // Arrange
    Event event = mock(Event.class);
    when(event.getEntityId()).thenReturn(null);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> eventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, event));
    verify(event).getEntityId();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EventDataValidator#validateDataImpl(TenantId, Event)} with {@code TenantId}, {@code
   * Event}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Event} {@link Event#getTenantId()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EventDataValidator#validateDataImpl(TenantId, Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventDataValidator.validateDataImpl(TenantId, Event)"})
  public void testValidateDataImplWithTenantIdEvent_givenNull_whenEventGetTenantIdReturnNull() {
    // Arrange
    Event event = mock(Event.class);
    when(event.getTenantId()).thenReturn(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> eventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, event));
    verify(event).getTenantId();
  }

  /**
   * Test {@link EventDataValidator#validateDataImpl(TenantId, Event)} with {@code TenantId}, {@code
   * Event}.
   *
   * <ul>
   *   <li>When {@link Event} {@link Event#getServiceId()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EventDataValidator#validateDataImpl(TenantId, Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventDataValidator.validateDataImpl(TenantId, Event)"})
  public void testValidateDataImplWithTenantIdEvent_whenEventGetServiceIdReturnNull() {
    // Arrange
    Event event = mock(Event.class);
    when(event.getServiceId()).thenReturn(null);
    when(event.getEntityId()).thenReturn(ModelConstants.NULL_UUID);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> eventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, event));
    verify(event).getEntityId();
    verify(event).getServiceId();
    verify(event).getTenantId();
  }
}
