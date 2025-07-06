package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {EdgeEventDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EdgeEventDataValidatorDiffblueTest {
  @Autowired private EdgeEventDataValidator edgeEventDataValidator;

  /**
   * Test {@link EdgeEventDataValidator#validateDataImpl(TenantId, EdgeEvent)} with {@code
   * TenantId}, {@code EdgeEvent}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventDataValidator#validateDataImpl(TenantId, EdgeEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeEventDataValidator.validateDataImpl(TenantId, EdgeEvent)"})
  public void testValidateDataImplWithTenantIdEdgeEvent_thenThrowDataValidationException() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setEdgeId(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> edgeEventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, edgeEvent));
  }

  /**
   * Test {@link EdgeEventDataValidator#validateDataImpl(TenantId, EdgeEvent)} with {@code
   * TenantId}, {@code EdgeEvent}.
   *
   * <ul>
   *   <li>When {@link EdgeEvent#EdgeEvent()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventDataValidator#validateDataImpl(TenantId, EdgeEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeEventDataValidator.validateDataImpl(TenantId, EdgeEvent)"})
  public void testValidateDataImplWithTenantIdEdgeEvent_whenEdgeEvent() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            edgeEventDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new EdgeEvent()));
  }
}
