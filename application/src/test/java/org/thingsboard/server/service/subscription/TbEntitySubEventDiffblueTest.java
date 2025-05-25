package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;

class TbEntitySubEventDiffblueTest {
  /**
   * Test {@link TbEntitySubEvent#hasTsOrAttrSub()}.
   * <p>
   * Method under test: {@link TbEntitySubEvent#hasTsOrAttrSub()}
   */
  @Test
  @DisplayName("Test hasTsOrAttrSub()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntitySubEvent.hasTsOrAttrSub()"})
  void testHasTsOrAttrSub() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertFalse((new TbEntitySubEvent(tenantId, null, ComponentLifecycleEvent.CREATED, new TbSubscriptionsInfo(), 10))
        .hasTsOrAttrSub());
  }

  /**
   * Test {@link TbEntitySubEvent#hasTsOrAttrSub()}.
   * <p>
   * Method under test: {@link TbEntitySubEvent#hasTsOrAttrSub()}
   */
  @Test
  @DisplayName("Test hasTsOrAttrSub()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntitySubEvent.hasTsOrAttrSub()"})
  void testHasTsOrAttrSub2() {
    // Arrange, Act and Assert
    assertFalse((new TbEntitySubEvent(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null,
        ComponentLifecycleEvent.CREATED, null, 10)).hasTsOrAttrSub());
  }

  /**
   * Test {@link TbEntitySubEvent#hasTsOrAttrSub()}.
   * <p>
   * Method under test: {@link TbEntitySubEvent#hasTsOrAttrSub()}
   */
  @Test
  @DisplayName("Test hasTsOrAttrSub()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntitySubEvent.hasTsOrAttrSub()"})
  void testHasTsOrAttrSub3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashSet<String> tsKeys = new HashSet<>();

    // Act and Assert
    assertTrue((new TbEntitySubEvent(tenantId, null, ComponentLifecycleEvent.CREATED,
        new TbSubscriptionsInfo(true, true, true, tsKeys, true, new HashSet<>(), 10), 10)).hasTsOrAttrSub());
  }

  /**
   * Test {@link TbEntitySubEvent#hasTsOrAttrSub()}.
   * <p>
   * Method under test: {@link TbEntitySubEvent#hasTsOrAttrSub()}
   */
  @Test
  @DisplayName("Test hasTsOrAttrSub()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntitySubEvent.hasTsOrAttrSub()"})
  void testHasTsOrAttrSub4() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashSet<String> tsKeys = new HashSet<>();

    // Act and Assert
    assertTrue((new TbEntitySubEvent(tenantId, null, ComponentLifecycleEvent.CREATED,
        new TbSubscriptionsInfo(true, true, false, tsKeys, true, new HashSet<>(), 10), 10)).hasTsOrAttrSub());
  }

  /**
   * Test {@link TbEntitySubEvent#hasTsOrAttrSub()}.
   * <p>
   * Method under test: {@link TbEntitySubEvent#hasTsOrAttrSub()}
   */
  @Test
  @DisplayName("Test hasTsOrAttrSub()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntitySubEvent.hasTsOrAttrSub()"})
  void testHasTsOrAttrSub5() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashSet<String> tsKeys = new HashSet<>();

    // Act and Assert
    assertTrue((new TbEntitySubEvent(tenantId, null, ComponentLifecycleEvent.CREATED,
        new TbSubscriptionsInfo(true, true, false, tsKeys, false, new HashSet<>(), 10), 10)).hasTsOrAttrSub());
  }
}
