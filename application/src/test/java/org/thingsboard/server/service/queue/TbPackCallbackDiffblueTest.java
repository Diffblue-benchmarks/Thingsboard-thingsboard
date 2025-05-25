package org.thingsboard.server.service.queue;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TbPackCallback.class, UUID.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class TbPackCallbackDiffblueTest {
  @Autowired
  private TbPackCallback<Object> tbPackCallback;

  @MockBean
  private TbPackProcessingContext<Object> tbPackProcessingContext;

  @MockBean
  private UUID uUID;

  /**
   * Test {@link TbPackCallback#onSuccess()}.
   * <ul>
   *   <li>Then calls {@link TbPackProcessingContext#onSuccess(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbPackCallback#onSuccess()}
   */
  @Test
  @DisplayName("Test onSuccess(); then calls onSuccess(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbPackCallback.onSuccess()"})
  void testOnSuccess_thenCallsOnSuccess() {
    // Arrange
    TbPackProcessingContext<Object> ctx = mock(TbPackProcessingContext.class);
    doNothing().when(ctx).onSuccess(Mockito.<UUID>any());
    TbPackCallback<Object> tbPackCallback = new TbPackCallback<>(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), ctx);

    // Act
    tbPackCallback.onSuccess();

    // Assert
    verify(ctx).onSuccess(isA(UUID.class));
  }

  /**
   * Test {@link TbPackCallback#onFailure(Throwable)}.
   * <ul>
   *   <li>Then calls {@link TbPackProcessingContext#onFailure(UUID, Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbPackCallback#onFailure(Throwable)}
   */
  @Test
  @DisplayName("Test onFailure(Throwable); then calls onFailure(UUID, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbPackCallback.onFailure(Throwable)"})
  void testOnFailure_thenCallsOnFailure() {
    // Arrange
    doNothing().when(tbPackProcessingContext).onFailure(Mockito.<UUID>any(), Mockito.<Throwable>any());

    // Act
    tbPackCallback.onFailure(new Throwable());

    // Assert
    verify(tbPackProcessingContext).onFailure(isA(UUID.class), isA(Throwable.class));
  }
}
