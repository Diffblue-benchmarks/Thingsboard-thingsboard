package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.aot.DisabledInAotMode;

@DisabledInAotMode
class EntityCountUpdateDiffblueTest {
  @MockBean
  private EntityCountUpdate entityCountUpdate;

  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return toString is {@code EntityCountUpdate(count=0)}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountUpdate#EntityCountUpdate(int, int, String)}
   *   <li>{@link EntityCountUpdate#toString()}
   *   <li>{@link EntityCountUpdate#getCmdUpdateType()}
   *   <li>{@link EntityCountUpdate#getCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return toString is 'EntityCountUpdate(count=0)'")
  void testGettersAndSetters_thenReturnToStringIsEntityCountUpdateCount0() {
    // Arrange and Act
    EntityCountUpdate actualEntityCountUpdate = new EntityCountUpdate(1, -1, "An error occurred");
    String actualToStringResult = actualEntityCountUpdate.toString();
    CmdUpdateType actualCmdUpdateType = actualEntityCountUpdate.getCmdUpdateType();
    int actualCount = actualEntityCountUpdate.getCount();

    // Assert
    assertEquals("An error occurred", actualEntityCountUpdate.getErrorMsg());
    assertEquals("EntityCountUpdate(count=0)", actualToStringResult);
    assertEquals(-1, actualEntityCountUpdate.getErrorCode());
    assertEquals(0, actualCount);
    assertEquals(1, actualEntityCountUpdate.getCmdId());
    assertEquals(CmdUpdateType.COUNT_DATA, actualCmdUpdateType);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return toString is {@code EntityCountUpdate(count=3)}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountUpdate#EntityCountUpdate(int, int, int, String)}
   *   <li>{@link EntityCountUpdate#toString()}
   *   <li>{@link EntityCountUpdate#getCmdUpdateType()}
   *   <li>{@link EntityCountUpdate#getCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when three; then return toString is 'EntityCountUpdate(count=3)'")
  void testGettersAndSetters_whenThree_thenReturnToStringIsEntityCountUpdateCount3() {
    // Arrange and Act
    EntityCountUpdate actualEntityCountUpdate = new EntityCountUpdate(1, 3, -1, "An error occurred");
    String actualToStringResult = actualEntityCountUpdate.toString();
    CmdUpdateType actualCmdUpdateType = actualEntityCountUpdate.getCmdUpdateType();
    int actualCount = actualEntityCountUpdate.getCount();

    // Assert
    assertEquals("An error occurred", actualEntityCountUpdate.getErrorMsg());
    assertEquals("EntityCountUpdate(count=3)", actualToStringResult);
    assertEquals(-1, actualEntityCountUpdate.getErrorCode());
    assertEquals(1, actualEntityCountUpdate.getCmdId());
    assertEquals(3, actualCount);
    assertEquals(CmdUpdateType.COUNT_DATA, actualCmdUpdateType);
  }

  /**
   * Test {@link EntityCountUpdate#EntityCountUpdate(int, int)}.
   * <p>
   * Method under test: {@link EntityCountUpdate#EntityCountUpdate(int, int)}
   */
  @Test
  @DisplayName("Test new EntityCountUpdate(int, int)")
  void testNewEntityCountUpdate() {
    // Arrange and Act
    EntityCountUpdate actualEntityCountUpdate = new EntityCountUpdate(1, 3);

    // Assert
    assertNull(actualEntityCountUpdate.getErrorMsg());
    assertEquals(0, actualEntityCountUpdate.getErrorCode());
    assertEquals(1, actualEntityCountUpdate.getCmdId());
    assertEquals(3, actualEntityCountUpdate.getCount());
    assertEquals(CmdUpdateType.COUNT_DATA, actualEntityCountUpdate.getCmdUpdateType());
  }
}
