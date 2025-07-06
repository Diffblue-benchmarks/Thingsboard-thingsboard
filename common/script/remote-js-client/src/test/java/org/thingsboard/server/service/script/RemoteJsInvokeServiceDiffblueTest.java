package org.thingsboard.server.service.script;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.script.api.js.JsScriptInfo;

@ExtendWith(MockitoExtension.class)
class RemoteJsInvokeServiceDiffblueTest {
  @InjectMocks private RemoteJsInvokeService remoteJsInvokeService;

  /**
   * Test {@link RemoteJsInvokeService#doInvokeFunction(UUID, JsScriptInfo, Object[])} with {@code
   * scriptId}, {@code jsInfo}, {@code args}.
   *
   * <ul>
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link RemoteJsInvokeService#doInvokeFunction(UUID, JsScriptInfo,
   * Object[])}
   */
  @Test
  @DisplayName(
      "Test doInvokeFunction(UUID, JsScriptInfo, Object[]) with 'scriptId', 'jsInfo', 'args'; then return Done")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture RemoteJsInvokeService.doInvokeFunction(UUID, JsScriptInfo, Object[])"
  })
  void testDoInvokeFunctionWithScriptIdJsInfoArgs_thenReturnDone() {
    // Arrange
    UUID scriptId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertTrue(
        remoteJsInvokeService
            .doInvokeFunction(
                scriptId, new JsScriptInfo("Hash", "Function Name"), new Object[] {"Args"})
            .isDone());
  }

  /**
   * Test {@link RemoteJsInvokeService#constructFunctionName(UUID, String)}.
   *
   * <p>Method under test: {@link RemoteJsInvokeService#constructFunctionName(UUID, String)}
   */
  @Test
  @DisplayName("Test constructFunctionName(UUID, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RemoteJsInvokeService.constructFunctionName(UUID, String)"})
  void testConstructFunctionName() {
    // Arrange, Act and Assert
    assertEquals(
        "invokeInternal_Script Hash",
        remoteJsInvokeService.constructFunctionName(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Script Hash"));
  }

  /**
   * Test {@link RemoteJsInvokeService#getScriptHash(UUID)}.
   *
   * <ul>
   *   <li>When fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RemoteJsInvokeService#getScriptHash(UUID)}
   */
  @Test
  @DisplayName(
      "Test getScriptHash(UUID); when fromString '784f394c-42b6-435a-983c-b7beff2784f9'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RemoteJsInvokeService.getScriptHash(UUID)"})
  void testGetScriptHash_whenFromString784f394c42b6435a983cB7beff2784f9_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        remoteJsInvokeService.getScriptHash(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }
}
