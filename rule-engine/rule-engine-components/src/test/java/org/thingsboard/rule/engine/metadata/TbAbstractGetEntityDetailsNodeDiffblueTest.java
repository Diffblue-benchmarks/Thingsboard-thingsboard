/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
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
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.msg.TbMsg;

class TbAbstractGetEntityDetailsNodeDiffblueTest {
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

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    tbGetCustomerDetailsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg, atLeast(1)).getOriginator();
  }

  /**
   * Test {@link TbAbstractGetEntityDetailsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getDbCallbackExecutor()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractGetEntityDetailsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); when TbContext getDbCallbackExecutor() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractGetEntityDetailsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextGetDbCallbackExecutorReturnNull() {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(null);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    tbGetCustomerDetailsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg, atLeast(1)).getOriginator();
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
