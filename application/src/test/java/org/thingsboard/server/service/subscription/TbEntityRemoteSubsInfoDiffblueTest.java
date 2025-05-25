package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class TbEntityRemoteSubsInfoDiffblueTest {
  @Mock
  private EntityId entityId;

  @InjectMocks
  private TbEntityRemoteSubsInfo tbEntityRemoteSubsInfo;

  @InjectMocks
  private TenantId tenantId;

  /**
   * Test {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}.
   * <p>
   * Method under test: {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test updateAndCheckIsEmpty(String, TbEntitySubEvent)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntityRemoteSubsInfo.updateAndCheckIsEmpty(String, TbEntitySubEvent)"})
  void testUpdateAndCheckIsEmpty() {
    // Arrange and Act
    boolean actualUpdateAndCheckIsEmptyResult = tbEntityRemoteSubsInfo.updateAndCheckIsEmpty("42",
        new TbEntitySubEvent(tenantId, entityId, ComponentLifecycleEvent.UPDATED, new TbSubscriptionsInfo(), 10));

    // Assert
    assertTrue(tbEntityRemoteSubsInfo.getSubs().isEmpty());
    assertTrue(tbEntityRemoteSubsInfo.isEmpty());
    assertTrue(actualUpdateAndCheckIsEmptyResult);
  }

  /**
   * Test {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}.
   * <p>
   * Method under test: {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test updateAndCheckIsEmpty(String, TbEntitySubEvent)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntityRemoteSubsInfo.updateAndCheckIsEmpty(String, TbEntitySubEvent)"})
  void testUpdateAndCheckIsEmpty2() {
    // Arrange and Act
    boolean actualUpdateAndCheckIsEmptyResult = tbEntityRemoteSubsInfo.updateAndCheckIsEmpty("42",
        new TbEntitySubEvent(tenantId, entityId, ComponentLifecycleEvent.DELETED, new TbSubscriptionsInfo(), 10));

    // Assert
    assertTrue(tbEntityRemoteSubsInfo.getSubs().isEmpty());
    assertTrue(tbEntityRemoteSubsInfo.isEmpty());
    assertTrue(actualUpdateAndCheckIsEmptyResult);
  }

  /**
   * Test {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}.
   * <p>
   * Method under test: {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test updateAndCheckIsEmpty(String, TbEntitySubEvent)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntityRemoteSubsInfo.updateAndCheckIsEmpty(String, TbEntitySubEvent)"})
  void testUpdateAndCheckIsEmpty3() {
    // Arrange
    HashSet<String> tsKeys = new HashSet<>();
    TbSubscriptionsInfo info = new TbSubscriptionsInfo(true, true, true, tsKeys, true, new HashSet<>(), 10);

    // Act
    tbEntityRemoteSubsInfo.updateAndCheckIsEmpty("42",
        new TbEntitySubEvent(tenantId, entityId, ComponentLifecycleEvent.UPDATED, info, 10));

    // Assert
    Map<String, TbSubscriptionsInfo> subs = tbEntityRemoteSubsInfo.getSubs();
    assertEquals(1, subs.size());
    assertFalse(tbEntityRemoteSubsInfo.isEmpty());
    assertSame(info, subs.get("42"));
  }

  /**
   * Test {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test updateAndCheckIsEmpty(String, TbEntitySubEvent); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntityRemoteSubsInfo.updateAndCheckIsEmpty(String, TbEntitySubEvent)"})
  void testUpdateAndCheckIsEmpty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(tbEntityRemoteSubsInfo.updateAndCheckIsEmpty("42",
        new TbEntitySubEvent(tenantId, entityId, ComponentLifecycleEvent.STARTED, new TbSubscriptionsInfo(), 10)));
    assertTrue(tbEntityRemoteSubsInfo.getSubs().isEmpty());
    assertTrue(tbEntityRemoteSubsInfo.isEmpty());
  }

  /**
   * Test {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}.
   * <ul>
   *   <li>Then {@link TbEntityRemoteSubsInfo} Subs {@code 42} is {@link TbSubscriptionsInfo#TbSubscriptionsInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityRemoteSubsInfo#updateAndCheckIsEmpty(String, TbEntitySubEvent)}
   */
  @Test
  @DisplayName("Test updateAndCheckIsEmpty(String, TbEntitySubEvent); then TbEntityRemoteSubsInfo Subs '42' is TbSubscriptionsInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntityRemoteSubsInfo.updateAndCheckIsEmpty(String, TbEntitySubEvent)"})
  void testUpdateAndCheckIsEmpty_thenTbEntityRemoteSubsInfoSubs42IsTbSubscriptionsInfo() {
    // Arrange
    TbSubscriptionsInfo info = new TbSubscriptionsInfo();

    // Act
    tbEntityRemoteSubsInfo.updateAndCheckIsEmpty("42",
        new TbEntitySubEvent(tenantId, entityId, ComponentLifecycleEvent.CREATED, info, 10));

    // Assert
    Map<String, TbSubscriptionsInfo> subs = tbEntityRemoteSubsInfo.getSubs();
    assertEquals(1, subs.size());
    assertFalse(tbEntityRemoteSubsInfo.isEmpty());
    assertSame(info, subs.get("42"));
  }

  /**
   * Test {@link TbEntityRemoteSubsInfo#removeAndCheckIsEmpty(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityRemoteSubsInfo#removeAndCheckIsEmpty(String)}
   */
  @Test
  @DisplayName("Test removeAndCheckIsEmpty(String); when '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntityRemoteSubsInfo.removeAndCheckIsEmpty(String)"})
  void testRemoveAndCheckIsEmpty_when42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(tbEntityRemoteSubsInfo.removeAndCheckIsEmpty("42"));
  }

  /**
   * Test {@link TbEntityRemoteSubsInfo#isEmpty()}.
   * <p>
   * Method under test: {@link TbEntityRemoteSubsInfo#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntityRemoteSubsInfo.isEmpty()"})
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue(tbEntityRemoteSubsInfo.isEmpty());
  }
}
