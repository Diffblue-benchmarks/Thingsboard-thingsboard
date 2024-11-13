package org.thingsboard.server.service.queue;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TbPackCallback.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
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
  void testOnSuccess_thenCallsOnSuccess() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbPackProcessingContext<Object> ctx = mock(TbPackProcessingContext.class);
    doNothing().when(ctx).onSuccess(Mockito.<UUID>any());
    TbPackCallback<Object> tbPackCallback = new TbPackCallback<>(UUID.randomUUID(), ctx);

    // Act
    tbPackCallback.onSuccess();

    // Assert that nothing has changed
    verify(ctx).onSuccess(isA(UUID.class));
  }

  /**
   * Test {@link TbPackCallback#onFailure(Throwable)}.
   * <p>
   * Method under test: {@link TbPackCallback#onFailure(Throwable)}
   */
  @Test
  @DisplayName("Test onFailure(Throwable)")
  void testOnFailure() {
    // Arrange
    doNothing().when(tbPackProcessingContext).onFailure(Mockito.<UUID>any(), Mockito.<Throwable>any());

    // Act
    tbPackCallback.onFailure(new Throwable());

    // Assert that nothing has changed
    verify(tbPackProcessingContext).onFailure(isA(UUID.class), isA(Throwable.class));
  }
}
