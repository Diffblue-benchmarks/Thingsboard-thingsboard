package org.thingsboard.server.service.ws.telemetry.cmd.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AttributesSubscriptionCmd.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class SubscriptionCmdDiffblueTest {
  @Autowired
  private SubscriptionCmd subscriptionCmd;

  /**
   * Test {@link SubscriptionCmd#toString()}.
   * <p>
   * Method under test: {@link SubscriptionCmd#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SubscriptionCmd.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("SubscriptionCmd [entityType=null, entityId=null, tags=null, unsubscribe=false]",
        subscriptionCmd.toString());
  }

  /**
   * Test {@link SubscriptionCmd#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(subscriptionCmd.canEqual("Other"));
  }

  /**
   * Test {@link SubscriptionCmd#canEqual(Object)}.
   * <ul>
   *   <li>When {@link SubscriptionCmd}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when SubscriptionCmd; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.canEqual(Object)"})
  void testCanEqual_whenSubscriptionCmd_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(subscriptionCmd.canEqual(subscriptionCmd));
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}, and {@link SubscriptionCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SubscriptionCmd#equals(Object)}
   *   <li>{@link SubscriptionCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();
    AttributesSubscriptionCmd attributesSubscriptionCmd2 = new AttributesSubscriptionCmd();

    // Act and Assert
    assertEquals(attributesSubscriptionCmd, attributesSubscriptionCmd2);
    int expectedHashCodeResult = attributesSubscriptionCmd.hashCode();
    assertEquals(expectedHashCodeResult, attributesSubscriptionCmd2.hashCode());
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}, and {@link SubscriptionCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SubscriptionCmd#equals(Object)}
   *   <li>{@link SubscriptionCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();
    attributesSubscriptionCmd.setScope("Scope");
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = mock(TimeseriesSubscriptionCmd.class);
    when(timeseriesSubscriptionCmd.isUnsubscribe()).thenReturn(false);
    when(timeseriesSubscriptionCmd.getCmdId()).thenReturn(0);
    when(timeseriesSubscriptionCmd.getEntityId()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getEntityType()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getKeys()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getScope()).thenReturn("Scope");
    when(timeseriesSubscriptionCmd.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(attributesSubscriptionCmd, timeseriesSubscriptionCmd);
    int notExpectedHashCodeResult = attributesSubscriptionCmd.hashCode();
    assertNotEquals(notExpectedHashCodeResult, timeseriesSubscriptionCmd.hashCode());
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}, and {@link SubscriptionCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SubscriptionCmd#equals(Object)}
   *   <li>{@link SubscriptionCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();

    // Act and Assert
    assertEquals(attributesSubscriptionCmd, attributesSubscriptionCmd);
    int expectedHashCodeResult = attributesSubscriptionCmd.hashCode();
    assertEquals(expectedHashCodeResult, attributesSubscriptionCmd.hashCode());
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AttributesSubscriptionCmd(), 1);
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();

    // Act and Assert
    assertNotEquals(attributesSubscriptionCmd, new TimeseriesSubscriptionCmd(1L, 10L, 42L, 1, "Agg"));
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = mock(TimeseriesSubscriptionCmd.class);
    when(timeseriesSubscriptionCmd.isUnsubscribe()).thenReturn(true);
    when(timeseriesSubscriptionCmd.getCmdId()).thenReturn(1);
    when(timeseriesSubscriptionCmd.getEntityId()).thenReturn("42");
    when(timeseriesSubscriptionCmd.getEntityType()).thenReturn("Entity Type");
    when(timeseriesSubscriptionCmd.getKeys()).thenReturn("Keys");
    when(timeseriesSubscriptionCmd.getScope()).thenReturn("Scope");
    when(timeseriesSubscriptionCmd.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(attributesSubscriptionCmd, timeseriesSubscriptionCmd);
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = mock(TimeseriesSubscriptionCmd.class);
    when(timeseriesSubscriptionCmd.isUnsubscribe()).thenReturn(true);
    when(timeseriesSubscriptionCmd.getCmdId()).thenReturn(0);
    when(timeseriesSubscriptionCmd.getEntityId()).thenReturn("42");
    when(timeseriesSubscriptionCmd.getEntityType()).thenReturn("Entity Type");
    when(timeseriesSubscriptionCmd.getKeys()).thenReturn("Keys");
    when(timeseriesSubscriptionCmd.getScope()).thenReturn("Scope");
    when(timeseriesSubscriptionCmd.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(attributesSubscriptionCmd, timeseriesSubscriptionCmd);
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = mock(TimeseriesSubscriptionCmd.class);
    when(timeseriesSubscriptionCmd.isUnsubscribe()).thenReturn(false);
    when(timeseriesSubscriptionCmd.getCmdId()).thenReturn(0);
    when(timeseriesSubscriptionCmd.getEntityId()).thenReturn("42");
    when(timeseriesSubscriptionCmd.getEntityType()).thenReturn("Entity Type");
    when(timeseriesSubscriptionCmd.getKeys()).thenReturn("Keys");
    when(timeseriesSubscriptionCmd.getScope()).thenReturn("Scope");
    when(timeseriesSubscriptionCmd.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(attributesSubscriptionCmd, timeseriesSubscriptionCmd);
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = mock(TimeseriesSubscriptionCmd.class);
    when(timeseriesSubscriptionCmd.isUnsubscribe()).thenReturn(false);
    when(timeseriesSubscriptionCmd.getCmdId()).thenReturn(0);
    when(timeseriesSubscriptionCmd.getEntityId()).thenReturn("42");
    when(timeseriesSubscriptionCmd.getEntityType()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getKeys()).thenReturn("Keys");
    when(timeseriesSubscriptionCmd.getScope()).thenReturn("Scope");
    when(timeseriesSubscriptionCmd.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(attributesSubscriptionCmd, timeseriesSubscriptionCmd);
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();
    attributesSubscriptionCmd.setEntityType("Entity Type");
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = mock(TimeseriesSubscriptionCmd.class);
    when(timeseriesSubscriptionCmd.isUnsubscribe()).thenReturn(false);
    when(timeseriesSubscriptionCmd.getCmdId()).thenReturn(0);
    when(timeseriesSubscriptionCmd.getEntityId()).thenReturn("42");
    when(timeseriesSubscriptionCmd.getEntityType()).thenReturn("Entity Type");
    when(timeseriesSubscriptionCmd.getKeys()).thenReturn("Keys");
    when(timeseriesSubscriptionCmd.getScope()).thenReturn("Scope");
    when(timeseriesSubscriptionCmd.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(attributesSubscriptionCmd, timeseriesSubscriptionCmd);
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = mock(TimeseriesSubscriptionCmd.class);
    when(timeseriesSubscriptionCmd.isUnsubscribe()).thenReturn(false);
    when(timeseriesSubscriptionCmd.getCmdId()).thenReturn(0);
    when(timeseriesSubscriptionCmd.getEntityId()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getEntityType()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getKeys()).thenReturn("Keys");
    when(timeseriesSubscriptionCmd.getScope()).thenReturn("Scope");
    when(timeseriesSubscriptionCmd.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(attributesSubscriptionCmd, timeseriesSubscriptionCmd);
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();
    attributesSubscriptionCmd.setEntityType("org.thingsboard.server.service.ws.telemetry.cmd.v1.SubscriptionCmd");
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = mock(TimeseriesSubscriptionCmd.class);
    when(timeseriesSubscriptionCmd.isUnsubscribe()).thenReturn(false);
    when(timeseriesSubscriptionCmd.getCmdId()).thenReturn(0);
    when(timeseriesSubscriptionCmd.getEntityId()).thenReturn("42");
    when(timeseriesSubscriptionCmd.getEntityType()).thenReturn("Entity Type");
    when(timeseriesSubscriptionCmd.getKeys()).thenReturn("Keys");
    when(timeseriesSubscriptionCmd.getScope()).thenReturn("Scope");
    when(timeseriesSubscriptionCmd.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(attributesSubscriptionCmd, timeseriesSubscriptionCmd);
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();
    attributesSubscriptionCmd.setEntityId("42");
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = mock(TimeseriesSubscriptionCmd.class);
    when(timeseriesSubscriptionCmd.isUnsubscribe()).thenReturn(false);
    when(timeseriesSubscriptionCmd.getCmdId()).thenReturn(0);
    when(timeseriesSubscriptionCmd.getEntityId()).thenReturn("42");
    when(timeseriesSubscriptionCmd.getEntityType()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getKeys()).thenReturn("Keys");
    when(timeseriesSubscriptionCmd.getScope()).thenReturn("Scope");
    when(timeseriesSubscriptionCmd.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(attributesSubscriptionCmd, timeseriesSubscriptionCmd);
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = mock(TimeseriesSubscriptionCmd.class);
    when(timeseriesSubscriptionCmd.isUnsubscribe()).thenReturn(false);
    when(timeseriesSubscriptionCmd.getCmdId()).thenReturn(0);
    when(timeseriesSubscriptionCmd.getEntityId()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getEntityType()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getKeys()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getScope()).thenReturn("Scope");
    when(timeseriesSubscriptionCmd.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(attributesSubscriptionCmd, timeseriesSubscriptionCmd);
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();
    attributesSubscriptionCmd.setEntityId("Entity Id");
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = mock(TimeseriesSubscriptionCmd.class);
    when(timeseriesSubscriptionCmd.isUnsubscribe()).thenReturn(false);
    when(timeseriesSubscriptionCmd.getCmdId()).thenReturn(0);
    when(timeseriesSubscriptionCmd.getEntityId()).thenReturn("42");
    when(timeseriesSubscriptionCmd.getEntityType()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getKeys()).thenReturn("Keys");
    when(timeseriesSubscriptionCmd.getScope()).thenReturn("Scope");
    when(timeseriesSubscriptionCmd.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(attributesSubscriptionCmd, timeseriesSubscriptionCmd);
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();
    attributesSubscriptionCmd.setKeys("Keys");
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = mock(TimeseriesSubscriptionCmd.class);
    when(timeseriesSubscriptionCmd.isUnsubscribe()).thenReturn(false);
    when(timeseriesSubscriptionCmd.getCmdId()).thenReturn(0);
    when(timeseriesSubscriptionCmd.getEntityId()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getEntityType()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getKeys()).thenReturn("Keys");
    when(timeseriesSubscriptionCmd.getScope()).thenReturn("Scope");
    when(timeseriesSubscriptionCmd.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(attributesSubscriptionCmd, timeseriesSubscriptionCmd);
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();
    attributesSubscriptionCmd.setKeys("org.thingsboard.server.service.ws.telemetry.cmd.v1.SubscriptionCmd");
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = mock(TimeseriesSubscriptionCmd.class);
    when(timeseriesSubscriptionCmd.isUnsubscribe()).thenReturn(false);
    when(timeseriesSubscriptionCmd.getCmdId()).thenReturn(0);
    when(timeseriesSubscriptionCmd.getEntityId()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getEntityType()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getKeys()).thenReturn("Keys");
    when(timeseriesSubscriptionCmd.getScope()).thenReturn("Scope");
    when(timeseriesSubscriptionCmd.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(attributesSubscriptionCmd, timeseriesSubscriptionCmd);
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();
    attributesSubscriptionCmd.setScope("org.thingsboard.server.service.ws.telemetry.cmd.v1.SubscriptionCmd");
    TimeseriesSubscriptionCmd timeseriesSubscriptionCmd = mock(TimeseriesSubscriptionCmd.class);
    when(timeseriesSubscriptionCmd.isUnsubscribe()).thenReturn(false);
    when(timeseriesSubscriptionCmd.getCmdId()).thenReturn(0);
    when(timeseriesSubscriptionCmd.getEntityId()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getEntityType()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getKeys()).thenReturn(null);
    when(timeseriesSubscriptionCmd.getScope()).thenReturn("Scope");
    when(timeseriesSubscriptionCmd.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(attributesSubscriptionCmd, timeseriesSubscriptionCmd);
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AttributesSubscriptionCmd(), null);
  }

  /**
   * Test {@link SubscriptionCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.equals(Object)", "int SubscriptionCmd.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AttributesSubscriptionCmd(), "Different type to SubscriptionCmd");
  }

  /**
   * Test {@link SubscriptionCmd#getCmdId()}.
   * <p>
   * Method under test: {@link SubscriptionCmd#getCmdId()}
   */
  @Test
  @DisplayName("Test getCmdId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int SubscriptionCmd.getCmdId()"})
  void testGetCmdId() {
    // Arrange, Act and Assert
    assertEquals(0, subscriptionCmd.getCmdId());
  }

  /**
   * Test {@link SubscriptionCmd#getEntityId()}.
   * <p>
   * Method under test: {@link SubscriptionCmd#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SubscriptionCmd.getEntityId()"})
  void testGetEntityId() {
    // Arrange, Act and Assert
    assertNull(subscriptionCmd.getEntityId());
  }

  /**
   * Test {@link SubscriptionCmd#getEntityType()}.
   * <p>
   * Method under test: {@link SubscriptionCmd#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SubscriptionCmd.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertNull(subscriptionCmd.getEntityType());
  }

  /**
   * Test {@link SubscriptionCmd#getKeys()}.
   * <p>
   * Method under test: {@link SubscriptionCmd#getKeys()}
   */
  @Test
  @DisplayName("Test getKeys()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SubscriptionCmd.getKeys()"})
  void testGetKeys() {
    // Arrange, Act and Assert
    assertNull(subscriptionCmd.getKeys());
  }

  /**
   * Test {@link SubscriptionCmd#getScope()}.
   * <p>
   * Method under test: {@link SubscriptionCmd#getScope()}
   */
  @Test
  @DisplayName("Test getScope()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SubscriptionCmd.getScope()"})
  void testGetScope() {
    // Arrange, Act and Assert
    assertNull(subscriptionCmd.getScope());
  }

  /**
   * Test {@link SubscriptionCmd#isUnsubscribe()}.
   * <ul>
   *   <li>Given {@link AttributesSubscriptionCmd} (default constructor) Unsubscribe is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#isUnsubscribe()}
   */
  @Test
  @DisplayName("Test isUnsubscribe(); given AttributesSubscriptionCmd (default constructor) Unsubscribe is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.isUnsubscribe()"})
  void testIsUnsubscribe_givenAttributesSubscriptionCmdUnsubscribeIsTrue_thenReturnTrue() {
    // Arrange
    AttributesSubscriptionCmd attributesSubscriptionCmd = new AttributesSubscriptionCmd();
    attributesSubscriptionCmd.setUnsubscribe(true);

    // Act and Assert
    assertTrue(attributesSubscriptionCmd.isUnsubscribe());
  }

  /**
   * Test {@link SubscriptionCmd#isUnsubscribe()}.
   * <ul>
   *   <li>Given {@link SubscriptionCmd}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionCmd#isUnsubscribe()}
   */
  @Test
  @DisplayName("Test isUnsubscribe(); given SubscriptionCmd; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SubscriptionCmd.isUnsubscribe()"})
  void testIsUnsubscribe_givenSubscriptionCmd_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(subscriptionCmd.isUnsubscribe());
  }

  /**
   * Test {@link SubscriptionCmd#setCmdId(int)}.
   * <p>
   * Method under test: {@link SubscriptionCmd#setCmdId(int)}
   */
  @Test
  @DisplayName("Test setCmdId(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SubscriptionCmd.setCmdId(int)"})
  void testSetCmdId() {
    // Arrange and Act
    subscriptionCmd.setCmdId(1);

    // Assert
    assertTrue(subscriptionCmd instanceof AttributesSubscriptionCmd);
    assertEquals(1, subscriptionCmd.getCmdId());
  }

  /**
   * Test {@link SubscriptionCmd#setEntityId(String)}.
   * <p>
   * Method under test: {@link SubscriptionCmd#setEntityId(String)}
   */
  @Test
  @DisplayName("Test setEntityId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SubscriptionCmd.setEntityId(String)"})
  void testSetEntityId() {
    // Arrange and Act
    subscriptionCmd.setEntityId("42");

    // Assert
    assertTrue(subscriptionCmd instanceof AttributesSubscriptionCmd);
    assertEquals("42", subscriptionCmd.getEntityId());
  }

  /**
   * Test {@link SubscriptionCmd#setEntityType(String)}.
   * <p>
   * Method under test: {@link SubscriptionCmd#setEntityType(String)}
   */
  @Test
  @DisplayName("Test setEntityType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SubscriptionCmd.setEntityType(String)"})
  void testSetEntityType() {
    // Arrange and Act
    subscriptionCmd.setEntityType("Entity Type");

    // Assert
    assertTrue(subscriptionCmd instanceof AttributesSubscriptionCmd);
    assertEquals("Entity Type", subscriptionCmd.getEntityType());
  }

  /**
   * Test {@link SubscriptionCmd#setKeys(String)}.
   * <p>
   * Method under test: {@link SubscriptionCmd#setKeys(String)}
   */
  @Test
  @DisplayName("Test setKeys(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SubscriptionCmd.setKeys(String)"})
  void testSetKeys() {
    // Arrange and Act
    subscriptionCmd.setKeys("Keys");

    // Assert
    assertTrue(subscriptionCmd instanceof AttributesSubscriptionCmd);
    assertEquals("Keys", subscriptionCmd.getKeys());
  }

  /**
   * Test {@link SubscriptionCmd#setScope(String)}.
   * <p>
   * Method under test: {@link SubscriptionCmd#setScope(String)}
   */
  @Test
  @DisplayName("Test setScope(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SubscriptionCmd.setScope(String)"})
  void testSetScope() {
    // Arrange and Act
    subscriptionCmd.setScope("Scope");

    // Assert
    assertTrue(subscriptionCmd instanceof AttributesSubscriptionCmd);
    assertEquals("Scope", subscriptionCmd.getScope());
  }

  /**
   * Test {@link SubscriptionCmd#setUnsubscribe(boolean)}.
   * <p>
   * Method under test: {@link SubscriptionCmd#setUnsubscribe(boolean)}
   */
  @Test
  @DisplayName("Test setUnsubscribe(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SubscriptionCmd.setUnsubscribe(boolean)"})
  void testSetUnsubscribe() {
    // Arrange and Act
    subscriptionCmd.setUnsubscribe(true);

    // Assert
    assertTrue(subscriptionCmd instanceof AttributesSubscriptionCmd);
    assertTrue(subscriptionCmd.isUnsubscribe());
  }
}
