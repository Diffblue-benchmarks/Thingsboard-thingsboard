package org.thingsboard.server.service.ws;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WsCommandsWrapperDiffblueTest {
  /**
   * Test {@link WsCommandsWrapper#equals(Object)}, and {@link WsCommandsWrapper#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WsCommandsWrapper#equals(Object)}
   *   <li>{@link WsCommandsWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WsCommandsWrapper.equals(Object)", "int WsCommandsWrapper.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WsCommandsWrapper wsCommandsWrapper = new WsCommandsWrapper();
    WsCommandsWrapper wsCommandsWrapper2 = new WsCommandsWrapper();

    // Act and Assert
    assertEquals(wsCommandsWrapper, wsCommandsWrapper2);
    int expectedHashCodeResult = wsCommandsWrapper.hashCode();
    assertEquals(expectedHashCodeResult, wsCommandsWrapper2.hashCode());
  }

  /**
   * Test {@link WsCommandsWrapper#equals(Object)}, and {@link WsCommandsWrapper#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WsCommandsWrapper#equals(Object)}
   *   <li>{@link WsCommandsWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WsCommandsWrapper.equals(Object)", "int WsCommandsWrapper.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AuthCmd authCmd = new AuthCmd(1, "ABC123");

    WsCommandsWrapper wsCommandsWrapper = new WsCommandsWrapper(authCmd, new ArrayList<>());
    AuthCmd authCmd2 = new AuthCmd(1, "ABC123");

    WsCommandsWrapper wsCommandsWrapper2 = new WsCommandsWrapper(authCmd2, new ArrayList<>());

    // Act and Assert
    assertEquals(wsCommandsWrapper, wsCommandsWrapper2);
    int expectedHashCodeResult = wsCommandsWrapper.hashCode();
    assertEquals(expectedHashCodeResult, wsCommandsWrapper2.hashCode());
  }

  /**
   * Test {@link WsCommandsWrapper#equals(Object)}, and {@link WsCommandsWrapper#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WsCommandsWrapper#equals(Object)}
   *   <li>{@link WsCommandsWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WsCommandsWrapper.equals(Object)", "int WsCommandsWrapper.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WsCommandsWrapper wsCommandsWrapper = new WsCommandsWrapper();

    // Act and Assert
    assertEquals(wsCommandsWrapper, wsCommandsWrapper);
    int expectedHashCodeResult = wsCommandsWrapper.hashCode();
    assertEquals(expectedHashCodeResult, wsCommandsWrapper.hashCode());
  }

  /**
   * Test {@link WsCommandsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WsCommandsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WsCommandsWrapper.equals(Object)", "int WsCommandsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AuthCmd authCmd = new AuthCmd(1, "ABC123");

    WsCommandsWrapper wsCommandsWrapper = new WsCommandsWrapper(authCmd, new ArrayList<>());

    // Act and Assert
    assertNotEquals(wsCommandsWrapper, new WsCommandsWrapper());
  }

  /**
   * Test {@link WsCommandsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WsCommandsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WsCommandsWrapper.equals(Object)", "int WsCommandsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WsCommandsWrapper wsCommandsWrapper = new WsCommandsWrapper();
    AuthCmd authCmd = new AuthCmd(1, "ABC123");

    // Act and Assert
    assertNotEquals(wsCommandsWrapper, new WsCommandsWrapper(authCmd, new ArrayList<>()));
  }

  /**
   * Test {@link WsCommandsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WsCommandsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WsCommandsWrapper.equals(Object)", "int WsCommandsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WsCommandsWrapper wsCommandsWrapper = new WsCommandsWrapper();
    wsCommandsWrapper.setCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(wsCommandsWrapper, new WsCommandsWrapper());
  }

  /**
   * Test {@link WsCommandsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WsCommandsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WsCommandsWrapper.equals(Object)", "int WsCommandsWrapper.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WsCommandsWrapper wsCommandsWrapper = new WsCommandsWrapper();

    WsCommandsWrapper wsCommandsWrapper2 = new WsCommandsWrapper();
    wsCommandsWrapper2.setCmds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(wsCommandsWrapper, wsCommandsWrapper2);
  }

  /**
   * Test {@link WsCommandsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WsCommandsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WsCommandsWrapper.equals(Object)", "int WsCommandsWrapper.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WsCommandsWrapper(), null);
  }

  /**
   * Test {@link WsCommandsWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WsCommandsWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WsCommandsWrapper.equals(Object)", "int WsCommandsWrapper.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WsCommandsWrapper(), "Different type to WsCommandsWrapper");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WsCommandsWrapper#WsCommandsWrapper()}
   *   <li>{@link WsCommandsWrapper#setAuthCmd(AuthCmd)}
   *   <li>{@link WsCommandsWrapper#setCmds(List)}
   *   <li>{@link WsCommandsWrapper#toString()}
   *   <li>{@link WsCommandsWrapper#getAuthCmd()}
   *   <li>{@link WsCommandsWrapper#getCmds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WsCommandsWrapper.<init>()", "void WsCommandsWrapper.<init>(AuthCmd, List)",
      "AuthCmd WsCommandsWrapper.getAuthCmd()", "List WsCommandsWrapper.getCmds()",
      "void WsCommandsWrapper.setAuthCmd(AuthCmd)", "void WsCommandsWrapper.setCmds(List)",
      "String WsCommandsWrapper.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    WsCommandsWrapper actualWsCommandsWrapper = new WsCommandsWrapper();
    AuthCmd authCmd = new AuthCmd(1, "ABC123");

    actualWsCommandsWrapper.setAuthCmd(authCmd);
    ArrayList<WsCmd> cmds = new ArrayList<>();
    actualWsCommandsWrapper.setCmds(cmds);
    String actualToStringResult = actualWsCommandsWrapper.toString();
    AuthCmd actualAuthCmd = actualWsCommandsWrapper.getAuthCmd();
    List<WsCmd> actualCmds = actualWsCommandsWrapper.getCmds();

    // Assert
    assertEquals("WsCommandsWrapper(authCmd=AuthCmd(cmdId=1, token=ABC123), cmds=[])", actualToStringResult);
    assertTrue(actualCmds.isEmpty());
    assertSame(cmds, actualCmds);
    assertSame(authCmd, actualAuthCmd);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link AuthCmd#AuthCmd(int, String)} with cmdId is one and token is {@code ABC123}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WsCommandsWrapper#WsCommandsWrapper(AuthCmd, List)}
   *   <li>{@link WsCommandsWrapper#setAuthCmd(AuthCmd)}
   *   <li>{@link WsCommandsWrapper#setCmds(List)}
   *   <li>{@link WsCommandsWrapper#toString()}
   *   <li>{@link WsCommandsWrapper#getAuthCmd()}
   *   <li>{@link WsCommandsWrapper#getCmds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when AuthCmd(int, String) with cmdId is one and token is 'ABC123'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WsCommandsWrapper.<init>()", "void WsCommandsWrapper.<init>(AuthCmd, List)",
      "AuthCmd WsCommandsWrapper.getAuthCmd()", "List WsCommandsWrapper.getCmds()",
      "void WsCommandsWrapper.setAuthCmd(AuthCmd)", "void WsCommandsWrapper.setCmds(List)",
      "String WsCommandsWrapper.toString()"})
  void testGettersAndSetters_whenAuthCmdWithCmdIdIsOneAndTokenIsAbc123() {
    // Arrange
    AuthCmd authCmd = new AuthCmd(1, "ABC123");

    // Act
    WsCommandsWrapper actualWsCommandsWrapper = new WsCommandsWrapper(authCmd, new ArrayList<>());
    AuthCmd authCmd2 = new AuthCmd(1, "ABC123");

    actualWsCommandsWrapper.setAuthCmd(authCmd2);
    ArrayList<WsCmd> cmds = new ArrayList<>();
    actualWsCommandsWrapper.setCmds(cmds);
    String actualToStringResult = actualWsCommandsWrapper.toString();
    AuthCmd actualAuthCmd = actualWsCommandsWrapper.getAuthCmd();
    List<WsCmd> actualCmds = actualWsCommandsWrapper.getCmds();

    // Assert
    assertEquals("WsCommandsWrapper(authCmd=AuthCmd(cmdId=1, token=ABC123), cmds=[])", actualToStringResult);
    assertTrue(actualCmds.isEmpty());
    assertSame(cmds, actualCmds);
    assertSame(authCmd2, actualAuthCmd);
  }
}
