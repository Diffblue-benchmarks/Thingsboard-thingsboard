package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.service.sync.vc.EntitiesVersionControlService;

@ExtendWith(MockitoExtension.class)
class AutoCommitControllerDiffblueTest {
  @InjectMocks
  private AutoCommitController autoCommitController;

  @Mock
  private EntitiesVersionControlService entitiesVersionControlService;

  /**
   * Test {@link AutoCommitController#autoCommit(User, EntityId)}.
   * <ul>
   *   <li>Given {@link AutoCommitController} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return Done.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoCommitController#autoCommit(User, EntityId)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityId); given AutoCommitController (default constructor); when 'null'; then return Done")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture AutoCommitController.autoCommit(User, EntityId)"})
  void testAutoCommit_givenAutoCommitController_whenNull_thenReturnDone() throws Exception {
    // Arrange
    AutoCommitController autoCommitController = new AutoCommitController();

    // Act and Assert
    assertTrue(autoCommitController.autoCommit(new User(), null).isDone());
  }

  /**
   * Test {@link AutoCommitController#autoCommit(User, EntityId)}.
   * <ul>
   *   <li>Then return {@link ApiFutureToListenableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoCommitController#autoCommit(User, EntityId)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityId); then return ApiFutureToListenableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture AutoCommitController.autoCommit(User, EntityId)"})
  void testAutoCommit_thenReturnApiFutureToListenableFuture() throws Exception {
    // Arrange
    SettableFuture<UUID> delegate = SettableFuture.create();
    ApiFutureToListenableFuture<UUID> apiFutureToListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    when(entitiesVersionControlService.autoCommit(Mockito.<User>any(), Mockito.<EntityId>any()))
        .thenReturn(apiFutureToListenableFuture);

    // Act
    ListenableFuture<UUID> actualAutoCommitResult = autoCommitController.autoCommit(new User(), null);

    // Assert
    verify(entitiesVersionControlService).autoCommit(isA(User.class), isNull());
    assertTrue(actualAutoCommitResult instanceof ApiFutureToListenableFuture);
    assertSame(apiFutureToListenableFuture, actualAutoCommitResult);
  }
}
