package org.thingsboard.server.service.entitiy.dashboard;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.service.sync.GitSyncService;

@ExtendWith(MockitoExtension.class)
class DashboardSyncServiceDiffblueTest {
  @InjectMocks
  private DashboardSyncService dashboardSyncService;

  @Mock
  private GitSyncService gitSyncService;

  /**
   * Test {@link DashboardSyncService#init()}.
   * <p>
   * Method under test: {@link DashboardSyncService#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DashboardSyncService.init()"})
  void testInit() throws Exception {
    // Arrange
    doNothing().when(gitSyncService)
        .registerSync(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(), anyLong(),
            Mockito.<Runnable>any());

    // Act
    dashboardSyncService.init();

    // Assert
    verify(gitSyncService).registerSync(eq("gateways-dashboard"), isNull(), isNull(), eq(0L), isA(Runnable.class));
  }
}
