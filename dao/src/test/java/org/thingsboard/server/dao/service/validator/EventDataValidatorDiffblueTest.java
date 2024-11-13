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
import org.thingsboard.server.common.data.event.Event;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {EventDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class EventDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @Autowired
  private EventDataValidator eventDataValidator;

  /**
   * Test {@link EventDataValidator#validateDataImpl(TenantId, Event)} with
   * {@code TenantId}, {@code Event}.
   * <p>
   * Method under test:
   * {@link EventDataValidator#validateDataImpl(TenantId, Event)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEvent() {
    // Arrange
    Event event = mock(Event.class);
    when(event.getServiceId()).thenThrow(new DataValidationException("An error occurred"));
    when(event.getEntityId()).thenReturn(ModelConstants.NULL_UUID);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> eventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, event));
    verify(event).getEntityId();
    verify(event).getServiceId();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EventDataValidator#validateDataImpl(TenantId, Event)} with
   * {@code TenantId}, {@code Event}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link Event} {@link Event#getServiceId()} return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EventDataValidator#validateDataImpl(TenantId, Event)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEvent_given42_whenEventGetServiceIdReturn42() {
    // Arrange
    Event event = mock(Event.class);
    when(event.getServiceId()).thenReturn("42");
    when(event.getEntityId()).thenReturn(ModelConstants.NULL_UUID);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    eventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, event);

    // Assert that nothing has changed
    verify(event).getEntityId();
    verify(event).getServiceId();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EventDataValidator#validateDataImpl(TenantId, Event)} with
   * {@code TenantId}, {@code Event}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EventDataValidator#validateDataImpl(TenantId, Event)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEvent_givenEmptyString() {
    // Arrange
    Event event = mock(Event.class);
    when(event.getServiceId()).thenReturn("");
    when(event.getEntityId()).thenReturn(ModelConstants.NULL_UUID);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> eventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, event));
    verify(event).getEntityId();
    verify(event).getServiceId();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EventDataValidator#validateDataImpl(TenantId, Event)} with
   * {@code TenantId}, {@code Event}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Event} {@link Event#getEntityId()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EventDataValidator#validateDataImpl(TenantId, Event)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEvent_givenNull_whenEventGetEntityIdReturnNull() {
    // Arrange
    Event event = mock(Event.class);
    when(event.getEntityId()).thenReturn(null);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> eventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, event));
    verify(event).getEntityId();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EventDataValidator#validateDataImpl(TenantId, Event)} with
   * {@code TenantId}, {@code Event}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Event} {@link Event#getServiceId()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EventDataValidator#validateDataImpl(TenantId, Event)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEvent_givenNull_whenEventGetServiceIdReturnNull() {
    // Arrange
    Event event = mock(Event.class);
    when(event.getServiceId()).thenReturn(null);
    when(event.getEntityId()).thenReturn(ModelConstants.NULL_UUID);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> eventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, event));
    verify(event).getEntityId();
    verify(event).getServiceId();
    verify(event).getTenantId();
  }

  /**
   * Test {@link EventDataValidator#validateDataImpl(TenantId, Event)} with
   * {@code TenantId}, {@code Event}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Event} {@link Event#getTenantId()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EventDataValidator#validateDataImpl(TenantId, Event)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEvent_givenNull_whenEventGetTenantIdReturnNull() {
    // Arrange
    Event event = mock(Event.class);
    when(event.getTenantId()).thenReturn(null);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> eventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, event));
    verify(event).getTenantId();
  }
}
