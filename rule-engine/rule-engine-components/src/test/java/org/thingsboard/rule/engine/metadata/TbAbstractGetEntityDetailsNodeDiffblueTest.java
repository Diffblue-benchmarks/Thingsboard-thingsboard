package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.rule.engine.util.ContactBasedEntityDetails;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.msg.TbMsg;

class TbAbstractGetEntityDetailsNodeDiffblueTest {
  /**
   * Test {@link TbAbstractGetEntityDetailsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TbContext} {@link TbContext#getDbCallbackExecutor()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractGetEntityDetailsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'null'; when TbContext getDbCallbackExecutor() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractGetEntityDetailsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenNull_whenTbContextGetDbCallbackExecutorReturnNull() {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(null);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbGetCustomerDetailsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TestDbCallbackExecutor} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractGetEntityDetailsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given TestDbCallbackExecutor (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractGetEntityDetailsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTestDbCallbackExecutor() {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbGetCustomerDetailsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNode#checkIfDetailsListIsNotEmptyOrElseThrow(List)}.
   *
   * <ul>
   *   <li>Given {@code ID}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractGetEntityDetailsNode#checkIfDetailsListIsNotEmptyOrElseThrow(List)}
   */
  @Test
  @DisplayName(
      "Test checkIfDetailsListIsNotEmptyOrElseThrow(List); given 'ID'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbAbstractGetEntityDetailsNode.checkIfDetailsListIsNotEmptyOrElseThrow(List)"
  })
  void testCheckIfDetailsListIsNotEmptyOrElseThrow_givenId_thenDoesNotThrow()
      throws TbNodeException {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();

    ArrayList<ContactBasedEntityDetails> detailsList = new ArrayList<>();
    detailsList.add(ContactBasedEntityDetails.ID);

    // Act and Assert
    assertDoesNotThrow(
        () -> tbGetCustomerDetailsNode.checkIfDetailsListIsNotEmptyOrElseThrow(detailsList));
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNode#checkIfDetailsListIsNotEmptyOrElseThrow(List)}.
   *
   * <ul>
   *   <li>Given {@code TITLE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code TITLE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractGetEntityDetailsNode#checkIfDetailsListIsNotEmptyOrElseThrow(List)}
   */
  @Test
  @DisplayName(
      "Test checkIfDetailsListIsNotEmptyOrElseThrow(List); given 'TITLE'; when ArrayList() add 'TITLE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbAbstractGetEntityDetailsNode.checkIfDetailsListIsNotEmptyOrElseThrow(List)"
  })
  void testCheckIfDetailsListIsNotEmptyOrElseThrow_givenTitle_whenArrayListAddTitle()
      throws TbNodeException {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();

    ArrayList<ContactBasedEntityDetails> detailsList = new ArrayList<>();
    detailsList.add(ContactBasedEntityDetails.TITLE);
    detailsList.add(ContactBasedEntityDetails.ID);

    // Act and Assert
    assertDoesNotThrow(
        () -> tbGetCustomerDetailsNode.checkIfDetailsListIsNotEmptyOrElseThrow(detailsList));
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNode#checkIfDetailsListIsNotEmptyOrElseThrow(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractGetEntityDetailsNode#checkIfDetailsListIsNotEmptyOrElseThrow(List)}
   */
  @Test
  @DisplayName("Test checkIfDetailsListIsNotEmptyOrElseThrow(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbAbstractGetEntityDetailsNode.checkIfDetailsListIsNotEmptyOrElseThrow(List)"
  })
  void testCheckIfDetailsListIsNotEmptyOrElseThrow_whenArrayList() throws TbNodeException {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbGetCustomerDetailsNode.checkIfDetailsListIsNotEmptyOrElseThrow(new ArrayList<>()));
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNode#checkIfDetailsListIsNotEmptyOrElseThrow(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractGetEntityDetailsNode#checkIfDetailsListIsNotEmptyOrElseThrow(List)}
   */
  @Test
  @DisplayName(
      "Test checkIfDetailsListIsNotEmptyOrElseThrow(List); when 'null'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbAbstractGetEntityDetailsNode.checkIfDetailsListIsNotEmptyOrElseThrow(List)"
  })
  void testCheckIfDetailsListIsNotEmptyOrElseThrow_whenNull_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> new TbGetCustomerDetailsNode().checkIfDetailsListIsNotEmptyOrElseThrow(null));
  }
}
