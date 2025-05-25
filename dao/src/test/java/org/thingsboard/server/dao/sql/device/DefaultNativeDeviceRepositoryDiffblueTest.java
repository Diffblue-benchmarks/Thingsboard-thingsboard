package org.thingsboard.server.dao.sql.device;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.DeviceIdInfo;
import org.thingsboard.server.common.data.page.PageData;

@ContextConfiguration(classes = {DefaultNativeDeviceRepository.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultNativeDeviceRepositoryDiffblueTest {
  @Autowired
  private DefaultNativeDeviceRepository defaultNativeDeviceRepository;

  @MockBean
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link DefaultNativeDeviceRepository#findDeviceIdInfos(Pageable)}.
   * <p>
   * Method under test: {@link DefaultNativeDeviceRepository#findDeviceIdInfos(Pageable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DefaultNativeDeviceRepository.findDeviceIdInfos(Pageable)"})
  public void testFindDeviceIdInfos() throws TransactionException {
    // Arrange
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<DeviceIdInfo> actualFindDeviceIdInfosResult = defaultNativeDeviceRepository.findDeviceIdInfos(null);

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    assertSame(actualFindDeviceIdInfosResult.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
  }
}
