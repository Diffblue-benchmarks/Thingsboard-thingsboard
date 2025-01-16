package org.thingsboard.server.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.Properties;
import java.util.Set;
import org.hibernate.boot.TempTableDdlTransactionHandling;
import org.hibernate.dialect.DatabaseVersion;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.DmlTargetColumnQualifierSupport;
import org.hibernate.dialect.FunctionalDependencyAnalysisSupport;
import org.hibernate.dialect.FunctionalDependencyAnalysisSupportImpl;
import org.hibernate.dialect.NationalizationSupport;
import org.hibernate.dialect.NullOrdering;
import org.hibernate.dialect.RowLockStrategy;
import org.hibernate.dialect.SelectItemReferenceStrategy;
import org.hibernate.dialect.SimpleDatabaseVersion;
import org.hibernate.dialect.TimeZoneSupport;
import org.hibernate.dialect.aggregate.PostgreSQLAggregateSupport;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.PostgreSQLIdentityColumnSupport;
import org.hibernate.dialect.pagination.OffsetFetchLimitHandler;
import org.hibernate.dialect.sequence.PostgreSQLSequenceSupport;
import org.hibernate.dialect.sequence.SequenceSupport;
import org.hibernate.dialect.temptable.StandardTemporaryTableExporter;
import org.hibernate.dialect.temptable.TemporaryTableKind;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.hibernate.engine.jdbc.env.internal.DefaultSchemaNameResolver;
import org.hibernate.engine.jdbc.env.spi.NameQualifierSupport;
import org.hibernate.exception.spi.TemplatedViolatedConstraintNameExtractor;
import org.hibernate.procedure.internal.PostgreSQLCallableStatementSupport;
import org.hibernate.query.sqm.mutation.internal.temptable.AfterUseAction;
import org.hibernate.query.sqm.mutation.internal.temptable.BeforeUseAction;
import org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorLegacyImpl;
import org.hibernate.tool.schema.internal.StandardAuxiliaryDatabaseObjectExporter;
import org.hibernate.tool.schema.internal.StandardForeignKeyExporter;
import org.hibernate.tool.schema.internal.StandardIndexExporter;
import org.hibernate.tool.schema.internal.StandardSequenceExporter;
import org.hibernate.tool.schema.internal.StandardTableCleaner;
import org.hibernate.tool.schema.internal.StandardTableExporter;
import org.hibernate.tool.schema.internal.StandardTableMigrator;
import org.hibernate.tool.schema.internal.StandardUniqueKeyExporter;
import org.hibernate.tool.schema.internal.StandardUserDefinedTypeExporter;
import org.hibernate.tool.schema.spi.Cleaner;
import org.junit.Test;

public class ThingsboardPostgreSQLDialectDiffblueTest {
  /**
   * Test new {@link ThingsboardPostgreSQLDialect} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ThingsboardPostgreSQLDialect}
   */
  @Test
  public void testNewThingsboardPostgreSQLDialect() {
    // Arrange and Act
    ThingsboardPostgreSQLDialect actualThingsboardPostgreSQLDialect = new ThingsboardPostgreSQLDialect();

    // Assert
    assertTrue(actualThingsboardPostgreSQLDialect.getSizeStrategy() instanceof Dialect.SizeStrategyImpl);
    FunctionalDependencyAnalysisSupport functionalDependencyAnalysisSupport = actualThingsboardPostgreSQLDialect
        .getFunctionalDependencyAnalysisSupport();
    assertTrue(functionalDependencyAnalysisSupport instanceof FunctionalDependencyAnalysisSupportImpl);
    DatabaseVersion version = actualThingsboardPostgreSQLDialect.getVersion();
    assertTrue(version instanceof SimpleDatabaseVersion);
    assertTrue(actualThingsboardPostgreSQLDialect.getAggregateSupport() instanceof PostgreSQLAggregateSupport);
    IdentityColumnSupport identityColumnSupport = actualThingsboardPostgreSQLDialect.getIdentityColumnSupport();
    assertTrue(identityColumnSupport instanceof PostgreSQLIdentityColumnSupport);
    assertTrue(actualThingsboardPostgreSQLDialect.getLimitHandler() instanceof OffsetFetchLimitHandler);
    SequenceSupport sequenceSupport = actualThingsboardPostgreSQLDialect.getSequenceSupport();
    assertTrue(sequenceSupport instanceof PostgreSQLSequenceSupport);
    assertTrue(
        actualThingsboardPostgreSQLDialect.getTemporaryTableExporter() instanceof StandardTemporaryTableExporter);
    assertTrue(actualThingsboardPostgreSQLDialect.getUniqueDelegate() instanceof CreateTableUniqueDelegate);
    assertTrue(actualThingsboardPostgreSQLDialect.getSchemaNameResolver() instanceof DefaultSchemaNameResolver);
    assertTrue(actualThingsboardPostgreSQLDialect
        .getViolatedConstraintNameExtractor() instanceof TemplatedViolatedConstraintNameExtractor);
    assertTrue(
        actualThingsboardPostgreSQLDialect.getCallableStatementSupport() instanceof PostgreSQLCallableStatementSupport);
    assertTrue(actualThingsboardPostgreSQLDialect
        .getSequenceInformationExtractor() instanceof SequenceInformationExtractorLegacyImpl);
    assertTrue(actualThingsboardPostgreSQLDialect
        .getAuxiliaryDatabaseObjectExporter() instanceof StandardAuxiliaryDatabaseObjectExporter);
    assertTrue(actualThingsboardPostgreSQLDialect.getForeignKeyExporter() instanceof StandardForeignKeyExporter);
    assertTrue(actualThingsboardPostgreSQLDialect.getIndexExporter() instanceof StandardIndexExporter);
    assertTrue(actualThingsboardPostgreSQLDialect.getSequenceExporter() instanceof StandardSequenceExporter);
    Cleaner tableCleaner = actualThingsboardPostgreSQLDialect.getTableCleaner();
    assertTrue(tableCleaner instanceof StandardTableCleaner);
    assertTrue(actualThingsboardPostgreSQLDialect.getTableExporter() instanceof StandardTableExporter);
    assertTrue(actualThingsboardPostgreSQLDialect.getTableMigrator() instanceof StandardTableMigrator);
    assertTrue(actualThingsboardPostgreSQLDialect.getUniqueKeyExporter() instanceof StandardUniqueKeyExporter);
    assertTrue(
        actualThingsboardPostgreSQLDialect.getUserDefinedTypeExporter() instanceof StandardUserDefinedTypeExporter);
    assertEquals(" cascade", actualThingsboardPostgreSQLDialect.getCascadeConstraintsString());
    assertEquals(" for update nowait", actualThingsboardPostgreSQLDialect.getForUpdateNowaitString());
    assertEquals(" for update skip locked", actualThingsboardPostgreSQLDialect.getForUpdateSkipLockedString());
    assertEquals(" for update", actualThingsboardPostgreSQLDialect.getForUpdateString());
    assertEquals("", actualThingsboardPostgreSQLDialect.getAddColumnSuffixString());
    assertEquals("", actualThingsboardPostgreSQLDialect.getCreateUserDefinedTypeExtensionsString());
    assertEquals("", actualThingsboardPostgreSQLDialect.getCreateUserDefinedTypeKindString());
    assertEquals("", actualThingsboardPostgreSQLDialect.getNullColumnString());
    assertEquals("", actualThingsboardPostgreSQLDialect.getTableTypeString());
    assertEquals("", sequenceSupport.getFromDual());
    Properties defaultProperties = actualThingsboardPostgreSQLDialect.getDefaultProperties();
    assertEquals(3, defaultProperties.size());
    assertEquals("15", defaultProperties.get("hibernate.jdbc.batch_size"));
    assertEquals("add column", actualThingsboardPostgreSQLDialect.getAddColumnString());
    assertEquals("create table", actualThingsboardPostgreSQLDialect.getCreateMultisetTableString());
    assertEquals("create table", actualThingsboardPostgreSQLDialect.getCreateTableString());
    assertEquals("create table", actualThingsboardPostgreSQLDialect.getTemporaryTableCreateCommand());
    assertEquals("default values", actualThingsboardPostgreSQLDialect.getNoColumnsInsertString());
    assertEquals("delete from", actualThingsboardPostgreSQLDialect.getTemporaryTableTruncateCommand());
    assertEquals("drop constraint", actualThingsboardPostgreSQLDialect.getDropForeignKeyString());
    assertEquals("drop constraint", actualThingsboardPostgreSQLDialect.getDropUniqueKeyString());
    assertEquals("drop table", actualThingsboardPostgreSQLDialect.getTemporaryTableDropCommand());
    assertEquals("ilike", actualThingsboardPostgreSQLDialect.getCaseInsensitiveLike());
    assertEquals("lower", actualThingsboardPostgreSQLDialect.getLowercaseFunction());
    assertEquals("select * from information_schema.sequences",
        actualThingsboardPostgreSQLDialect.getQuerySequencesString());
    assertEquals("select current_schema()", actualThingsboardPostgreSQLDialect.getCurrentSchemaCommand());
    assertEquals("select now()", actualThingsboardPostgreSQLDialect.getCurrentTimestampSelectString());
    assertEquals("sequence", actualThingsboardPostgreSQLDialect.getNativeIdentifierGeneratorStrategy());
    assertNull(actualThingsboardPostgreSQLDialect.getDisableConstraintsStatement());
    assertNull(actualThingsboardPostgreSQLDialect.getEnableConstraintsStatement());
    assertNull(actualThingsboardPostgreSQLDialect.getTemporaryTableCreateOptions());
    assertNull(identityColumnSupport.getIdentityInsertString());
    assertNull(tableCleaner.getSqlAfterString());
    assertNull(tableCleaner.getSqlBeforeString());
    assertNull(actualThingsboardPostgreSQLDialect.getHqlTranslator());
    assertNull(actualThingsboardPostgreSQLDialect.getSqmTranslatorFactory());
    assertNull(actualThingsboardPostgreSQLDialect.getNativeParameterMarkerStrategy());
    assertEquals(0, version.getDatabaseMicroVersion());
    assertEquals(0, version.getDatabaseMinorVersion());
    assertEquals(0, version.getMicro());
    assertEquals(0, version.getMinor());
    assertEquals(0, actualThingsboardPostgreSQLDialect.getInExpressionCountLimit());
    assertEquals(0, actualThingsboardPostgreSQLDialect.getParameterCountLimit());
    assertEquals(0, actualThingsboardPostgreSQLDialect.ordinal());
    assertEquals(10, actualThingsboardPostgreSQLDialect.getMaxAliasLength());
    assertEquals(1000000000L, actualThingsboardPostgreSQLDialect.getFractionalSecondPrecisionInNanos());
    assertEquals(10485760, actualThingsboardPostgreSQLDialect.getMaxNVarcharCapacity());
    assertEquals(10485760, actualThingsboardPostgreSQLDialect.getMaxNVarcharLength());
    assertEquals(10485760, actualThingsboardPostgreSQLDialect.getMaxVarcharLength());
    assertEquals(1048576L, actualThingsboardPostgreSQLDialect.getDefaultLobLength());
    assertEquals(1073741824, actualThingsboardPostgreSQLDialect.getMaxVarcharCapacity());
    assertEquals(12, version.getDatabaseMajorVersion());
    assertEquals(12, version.getMajor());
    assertEquals(15, actualThingsboardPostgreSQLDialect.getDefaultStatementBatchSize());
    assertEquals(2003, actualThingsboardPostgreSQLDialect.getPreferredSqlTypeCodeForArray());
    assertEquals(24, actualThingsboardPostgreSQLDialect.getFloatPrecision());
    Set<String> keywords = actualThingsboardPostgreSQLDialect.getKeywords();
    assertEquals(243, keywords.size());
    assertEquals(38, actualThingsboardPostgreSQLDialect.getDefaultDecimalPrecision());
    assertEquals(53, actualThingsboardPostgreSQLDialect.getDoublePrecision());
    assertEquals(6, actualThingsboardPostgreSQLDialect.getDefaultTimestampPrecision());
    assertEquals(6, actualThingsboardPostgreSQLDialect.getDefaultIntervalSecondScale());
    assertEquals(63, actualThingsboardPostgreSQLDialect.getMaxIdentifierLength());
    assertEquals(TempTableDdlTransactionHandling.NONE,
        actualThingsboardPostgreSQLDialect.getTemporaryTableDdlTransactionHandling());
    assertEquals(DmlTargetColumnQualifierSupport.NONE,
        actualThingsboardPostgreSQLDialect.getDmlTargetColumnQualifierSupport());
    assertEquals(NationalizationSupport.IMPLICIT, actualThingsboardPostgreSQLDialect.getNationalizationSupport());
    assertEquals(NullOrdering.GREATEST, actualThingsboardPostgreSQLDialect.getNullOrdering());
    assertEquals(RowLockStrategy.TABLE, actualThingsboardPostgreSQLDialect.getReadRowLockStrategy());
    assertEquals(RowLockStrategy.TABLE, actualThingsboardPostgreSQLDialect.getWriteRowLockStrategy());
    assertEquals(SelectItemReferenceStrategy.POSITION,
        actualThingsboardPostgreSQLDialect.getGroupBySelectItemReferenceStrategy());
    assertEquals(TimeZoneSupport.NORMALIZE, actualThingsboardPostgreSQLDialect.getTimeZoneSupport());
    assertEquals(TemporaryTableKind.PERSISTENT, actualThingsboardPostgreSQLDialect.getSupportedTemporaryTableKind());
    assertEquals(NameQualifierSupport.SCHEMA, actualThingsboardPostgreSQLDialect.getNameQualifierSupport());
    assertEquals(AfterUseAction.CLEAN, actualThingsboardPostgreSQLDialect.getTemporaryTableAfterUseAction());
    assertEquals(BeforeUseAction.NONE, actualThingsboardPostgreSQLDialect.getTemporaryTableBeforeUseAction());
    assertFalse(actualThingsboardPostgreSQLDialect.hasSelfReferentialForeignKeyBug());
    assertFalse(actualThingsboardPostgreSQLDialect.isEmptyStringTreatedAsNull());
    assertFalse(actualThingsboardPostgreSQLDialect.isLockTimeoutParameterized());
    assertFalse(functionalDependencyAnalysisSupport.supportsConstants());
    assertFalse(functionalDependencyAnalysisSupport.supportsTableGroups());
    assertFalse(actualThingsboardPostgreSQLDialect.isCurrentTimestampSelectStringCallable());
    assertFalse(identityColumnSupport.hasDataTypeInIdentityColumn());
    assertFalse(identityColumnSupport.hasIdentityInsertKeyword());
    assertTrue(keywords.contains("dec"));
    assertTrue(keywords.contains("handler"));
    assertTrue(keywords.contains("leading"));
    assertTrue(keywords.contains("prepare"));
    assertTrue(keywords.contains("references"));
    assertTrue(keywords.contains("year"));
    assertTrue(actualThingsboardPostgreSQLDialect.getDefaultUseGetGeneratedKeys());
    assertTrue(actualThingsboardPostgreSQLDialect.hasAlterTable());
    assertTrue(actualThingsboardPostgreSQLDialect.hasDataTypeBeforeGeneratedAs());
    assertTrue(actualThingsboardPostgreSQLDialect.isAnsiNullOn());
    assertTrue(actualThingsboardPostgreSQLDialect.isJdbcLogWarningsEnabledByDefault());
    assertTrue(functionalDependencyAnalysisSupport.supportsAnalysis());
    assertTrue(actualThingsboardPostgreSQLDialect.getDefaultNonContextualLobCreation());
    String expectedString = Boolean.TRUE.toString();
    assertEquals(expectedString, defaultProperties.get("hibernate.jdbc.lob.non_contextual_creation"));
    String expectedString2 = Boolean.TRUE.toString();
    assertEquals(expectedString2, defaultProperties.get("hibernate.jdbc.use_get_generated_keys"));
    assertEquals(Integer.MAX_VALUE, actualThingsboardPostgreSQLDialect.getMaxVarbinaryCapacity());
    assertEquals(Integer.MAX_VALUE, actualThingsboardPostgreSQLDialect.getMaxVarbinaryLength());
    assertEquals(Short.SIZE, actualThingsboardPostgreSQLDialect.getPreferredSqlTypeCodeForBoolean());
  }
}
