package org.thingsboard.server.dao.entity;

import static org.junit.Assert.assertThrows;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.Dao;

@ContextConfiguration(classes = {EntityDaoRegistry.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class EntityDaoRegistryDiffblueTest {
  @MockBean
  private Dao<Object> dao;

  @Autowired
  private EntityDaoRegistry entityDaoRegistry;

  @Autowired
  private List<Dao<Object>> list;

  /**
   * Test {@link EntityDaoRegistry#getDao(EntityType)}.
   * <p>
   * Method under test: {@link EntityDaoRegistry#getDao(EntityType)}
   */
  @Test
  public void testGetDao() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityDaoRegistry.getDao(EntityType.TENANT));
  }
}
