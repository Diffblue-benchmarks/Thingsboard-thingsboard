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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.event.ErrorEvent;
import org.thingsboard.server.common.data.event.ErrorEvent.ErrorEventBuilder;
import org.thingsboard.server.common.data.event.Event;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

public class EventDataValidatorDiffblueTest {
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
    EventDataValidator eventDataValidator = new EventDataValidator();

    ErrorEvent event = mock(ErrorEvent.class);
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
    EventDataValidator eventDataValidator = new EventDataValidator();

    ErrorEvent event = mock(ErrorEvent.class);
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
   *   <li>Given builder.
   *   <li>Then calls {@link ErrorEventBuilder#entityId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link EventDataValidator#validateDataImpl(TenantId, Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventDataValidator.validateDataImpl(TenantId, Event)"})
  public void testValidateDataImplWithTenantIdEvent_givenBuilder_thenCallsEntityId() {
    // Arrange
    EventDataValidator eventDataValidator = new EventDataValidator();

    ErrorEventBuilder errorEventBuilder = mock(ErrorEventBuilder.class);
    when(errorEventBuilder.entityId(Mockito.<UUID>any())).thenReturn(ErrorEvent.builder());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            eventDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT,
                errorEventBuilder
                    .entityId(ModelConstants.NULL_UUID)
                    .error("An error occurred")
                    .id(ModelConstants.NULL_UUID)
                    .method("Method")
                    .serviceId("42")
                    .tenantId(ModelConstants.SYSTEM_TENANT)
                    .ts(1L)
                    .build()));
    verify(errorEventBuilder).entityId(isA(UUID.class));
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
    EventDataValidator eventDataValidator = new EventDataValidator();

    ErrorEvent event = mock(ErrorEvent.class);
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
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link EventDataValidator#validateDataImpl(TenantId, Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventDataValidator.validateDataImpl(TenantId, Event)"})
  public void testValidateDataImplWithTenantIdEvent_thenDoesNotThrow() {
    // Arrange
    EventDataValidator eventDataValidator = new EventDataValidator();

    // Act and Assert
    eventDataValidator.validateDataImpl(
        ModelConstants.SYSTEM_TENANT,
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
  }

  /**
   * Test {@link EventDataValidator#validateDataImpl(TenantId, Event)} with {@code TenantId}, {@code
   * Event}.
   *
   * <ul>
   *   <li>When {@link ErrorEvent} {@link ErrorEvent#getServiceId()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EventDataValidator#validateDataImpl(TenantId, Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventDataValidator.validateDataImpl(TenantId, Event)"})
  public void testValidateDataImplWithTenantIdEvent_whenErrorEventGetServiceIdReturnNull() {
    // Arrange
    EventDataValidator eventDataValidator = new EventDataValidator();

    ErrorEvent event = mock(ErrorEvent.class);
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

  /**
   * Test {@link EventDataValidator#validateDataImpl(TenantId, Event)} with {@code TenantId}, {@code
   * Event}.
   *
   * <ul>
   *   <li>When {@link ErrorEvent} {@link ErrorEvent#getTenantId()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EventDataValidator#validateDataImpl(TenantId, Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventDataValidator.validateDataImpl(TenantId, Event)"})
  public void testValidateDataImplWithTenantIdEvent_whenErrorEventGetTenantIdReturnNull() {
    // Arrange
    EventDataValidator eventDataValidator = new EventDataValidator();

    ErrorEvent event = mock(ErrorEvent.class);
    when(event.getTenantId()).thenReturn(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> eventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, event));
    verify(event).getTenantId();
  }
}
