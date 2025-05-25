package org.thingsboard.server.dao.rpc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.sql.rpc.JpaRpcDao;
import org.thingsboard.server.dao.sql.rpc.RpcRepository;

public class BaseRpcServiceDiffblueTest {
  /**
   * Test {@link BaseRpcService#getEntityType()}.
   * <p>
   * Method under test: {@link BaseRpcService#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType BaseRpcService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.RPC, (new BaseRpcService(new JpaRpcDao(mock(RpcRepository.class)))).getEntityType());
  }
}
