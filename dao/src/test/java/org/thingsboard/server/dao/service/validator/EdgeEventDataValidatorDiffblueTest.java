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
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {EdgeEventDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class EdgeEventDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @Autowired
  private EdgeEventDataValidator edgeEventDataValidator;

  /**
   * Test {@link EdgeEventDataValidator#validateDataImpl(TenantId, EdgeEvent)}
   * with {@code TenantId}, {@code EdgeEvent}.
   * <p>
   * Method under test:
   * {@link EdgeEventDataValidator#validateDataImpl(TenantId, EdgeEvent)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEdgeEvent() {
    // Arrange
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getAction()).thenThrow(new DataValidationException("An error occurred"));
    when(edgeEvent.getEdgeId()).thenReturn(new EdgeId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> edgeEventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edgeEvent));
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEdgeId();
  }

  /**
   * Test {@link EdgeEventDataValidator#validateDataImpl(TenantId, EdgeEvent)}
   * with {@code TenantId}, {@code EdgeEvent}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeEventDataValidator#validateDataImpl(TenantId, EdgeEvent)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEdgeEvent_givenAdded() {
    // Arrange
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.ADDED);
    when(edgeEvent.getEdgeId()).thenReturn(new EdgeId(ModelConstants.NULL_UUID));

    // Act
    edgeEventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edgeEvent);

    // Assert that nothing has changed
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEdgeId();
  }

  /**
   * Test {@link EdgeEventDataValidator#validateDataImpl(TenantId, EdgeEvent)}
   * with {@code TenantId}, {@code EdgeEvent}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeEventDataValidator#validateDataImpl(TenantId, EdgeEvent)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEdgeEvent_givenNull() {
    // Arrange
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getAction()).thenReturn(null);
    when(edgeEvent.getEdgeId()).thenReturn(new EdgeId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> edgeEventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edgeEvent));
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEdgeId();
  }

  /**
   * Test {@link EdgeEventDataValidator#validateDataImpl(TenantId, EdgeEvent)}
   * with {@code TenantId}, {@code EdgeEvent}.
   * <ul>
   *   <li>When {@link EdgeEvent#EdgeEvent()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeEventDataValidator#validateDataImpl(TenantId, EdgeEvent)}
   */
  @Test
  public void testValidateDataImplWithTenantIdEdgeEvent_whenEdgeEvent() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> edgeEventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new EdgeEvent()));
  }
}
