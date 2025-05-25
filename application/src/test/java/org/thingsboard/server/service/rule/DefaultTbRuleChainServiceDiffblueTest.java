package org.thingsboard.server.service.rule;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainUpdateResult;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.common.data.rule.RuleNodeUpdateResult;

@ExtendWith(MockitoExtension.class)
class DefaultTbRuleChainServiceDiffblueTest {
  @InjectMocks
  private DefaultTbRuleChainService defaultTbRuleChainService;

  /**
   * Test {@link DefaultTbRuleChainService#updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult)} with {@code tenantId}, {@code ruleChainId}, {@code result}.
   * <p>
   * Method under test: {@link DefaultTbRuleChainService#updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult)}
   */
  @Test
  @DisplayName("Test updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult) with 'tenantId', 'ruleChainId', 'result'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "List DefaultTbRuleChainService.updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult)"})
  void testUpdateRelatedRuleChainsWithTenantIdRuleChainIdResult() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<RuleNodeUpdateResult> ruleNodeUpdateResultList = new ArrayList<>();
    ruleNodeUpdateResultList.add(new RuleNodeUpdateResult(new RuleNode(), null));
    RuleChainUpdateResult result = mock(RuleChainUpdateResult.class);
    when(result.getUpdatedRuleNodes()).thenReturn(ruleNodeUpdateResultList);

    // Act
    List<RuleChain> actualUpdateRelatedRuleChainsResult = defaultTbRuleChainService.updateRelatedRuleChains(tenantId,
        ruleChainId, result);

    // Assert
    verify(result, atLeast(1)).getUpdatedRuleNodes();
    assertTrue(actualUpdateRelatedRuleChainsResult.isEmpty());
  }

  /**
   * Test {@link DefaultTbRuleChainService#updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult)} with {@code tenantId}, {@code ruleChainId}, {@code result}.
   * <p>
   * Method under test: {@link DefaultTbRuleChainService#updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult)}
   */
  @Test
  @DisplayName("Test updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult) with 'tenantId', 'ruleChainId', 'result'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "List DefaultTbRuleChainService.updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult)"})
  void testUpdateRelatedRuleChainsWithTenantIdRuleChainIdResult2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNode newRuleNode = mock(RuleNode.class);
    when(newRuleNode.getType()).thenReturn("Type");
    RuleNodeUpdateResult ruleNodeUpdateResult = new RuleNodeUpdateResult(new RuleNode(), newRuleNode);

    ArrayList<RuleNodeUpdateResult> ruleNodeUpdateResultList = new ArrayList<>();
    ruleNodeUpdateResultList.add(ruleNodeUpdateResult);
    RuleChainUpdateResult result = mock(RuleChainUpdateResult.class);
    when(result.getUpdatedRuleNodes()).thenReturn(ruleNodeUpdateResultList);

    // Act
    List<RuleChain> actualUpdateRelatedRuleChainsResult = defaultTbRuleChainService.updateRelatedRuleChains(tenantId,
        ruleChainId, result);

    // Assert
    verify(result, atLeast(1)).getUpdatedRuleNodes();
    verify(newRuleNode).getType();
    assertTrue(actualUpdateRelatedRuleChainsResult.isEmpty());
  }

  /**
   * Test {@link DefaultTbRuleChainService#updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult)} with {@code tenantId}, {@code ruleChainId}, {@code result}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRuleChainService#updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult)}
   */
  @Test
  @DisplayName("Test updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult) with 'tenantId', 'ruleChainId', 'result'; given ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "List DefaultTbRuleChainService.updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult)"})
  void testUpdateRelatedRuleChainsWithTenantIdRuleChainIdResult_givenArrayList() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainUpdateResult result = mock(RuleChainUpdateResult.class);
    when(result.getUpdatedRuleNodes()).thenReturn(new ArrayList<>());

    // Act
    List<RuleChain> actualUpdateRelatedRuleChainsResult = defaultTbRuleChainService.updateRelatedRuleChains(tenantId,
        ruleChainId, result);

    // Assert
    verify(result, atLeast(1)).getUpdatedRuleNodes();
    assertTrue(actualUpdateRelatedRuleChainsResult.isEmpty());
  }

  /**
   * Test {@link DefaultTbRuleChainService#updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult)} with {@code tenantId}, {@code ruleChainId}, {@code result}.
   * <ul>
   *   <li>When failed.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRuleChainService#updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult)}
   */
  @Test
  @DisplayName("Test updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult) with 'tenantId', 'ruleChainId', 'result'; when failed")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "List DefaultTbRuleChainService.updateRelatedRuleChains(TenantId, RuleChainId, RuleChainUpdateResult)"})
  void testUpdateRelatedRuleChainsWithTenantIdRuleChainIdResult_whenFailed() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId ruleChainId = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertTrue(defaultTbRuleChainService.updateRelatedRuleChains(tenantId, ruleChainId, RuleChainUpdateResult.failed())
        .isEmpty());
  }
}
