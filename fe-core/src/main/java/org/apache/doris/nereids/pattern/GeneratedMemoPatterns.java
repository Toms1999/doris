// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.nereids.pattern;

import org.apache.doris.nereids.analyzer.UnboundOneRowRelation;
import org.apache.doris.nereids.analyzer.UnboundRelation;
import org.apache.doris.nereids.analyzer.UnboundTVFRelation;
import org.apache.doris.nereids.trees.plans.GroupPlan;
import org.apache.doris.nereids.trees.plans.JoinHint;
import org.apache.doris.nereids.trees.plans.JoinType;
import org.apache.doris.nereids.trees.plans.LimitPhase;
import org.apache.doris.nereids.trees.plans.Plan;
import org.apache.doris.nereids.trees.plans.logical.LogicalAggregate;
import org.apache.doris.nereids.trees.plans.logical.LogicalApply;
import org.apache.doris.nereids.trees.plans.logical.LogicalAssertNumRows;
import org.apache.doris.nereids.trees.plans.logical.LogicalCTE;
import org.apache.doris.nereids.trees.plans.logical.LogicalCheckPolicy;
import org.apache.doris.nereids.trees.plans.logical.LogicalEmptyRelation;
import org.apache.doris.nereids.trees.plans.logical.LogicalEsScan;
import org.apache.doris.nereids.trees.plans.logical.LogicalFileScan;
import org.apache.doris.nereids.trees.plans.logical.LogicalFilter;
import org.apache.doris.nereids.trees.plans.logical.LogicalGenerate;
import org.apache.doris.nereids.trees.plans.logical.LogicalHaving;
import org.apache.doris.nereids.trees.plans.logical.LogicalJdbcScan;
import org.apache.doris.nereids.trees.plans.logical.LogicalJoin;
import org.apache.doris.nereids.trees.plans.logical.LogicalLimit;
import org.apache.doris.nereids.trees.plans.logical.LogicalOlapScan;
import org.apache.doris.nereids.trees.plans.logical.LogicalOneRowRelation;
import org.apache.doris.nereids.trees.plans.logical.LogicalProject;
import org.apache.doris.nereids.trees.plans.logical.LogicalRepeat;
import org.apache.doris.nereids.trees.plans.logical.LogicalSchemaScan;
import org.apache.doris.nereids.trees.plans.logical.LogicalSelectHint;
import org.apache.doris.nereids.trees.plans.logical.LogicalSort;
import org.apache.doris.nereids.trees.plans.logical.LogicalSubQueryAlias;
import org.apache.doris.nereids.trees.plans.logical.LogicalTVFRelation;
import org.apache.doris.nereids.trees.plans.logical.LogicalTopN;
import org.apache.doris.nereids.trees.plans.logical.LogicalWindow;
import org.apache.doris.nereids.trees.plans.logical.UsingJoin;
import org.apache.doris.nereids.trees.plans.physical.PhysicalAssertNumRows;
import org.apache.doris.nereids.trees.plans.physical.PhysicalDistribute;
import org.apache.doris.nereids.trees.plans.physical.PhysicalEmptyRelation;
import org.apache.doris.nereids.trees.plans.physical.PhysicalEsScan;
import org.apache.doris.nereids.trees.plans.physical.PhysicalFileScan;
import org.apache.doris.nereids.trees.plans.physical.PhysicalFilter;
import org.apache.doris.nereids.trees.plans.physical.PhysicalGenerate;
import org.apache.doris.nereids.trees.plans.physical.PhysicalHashAggregate;
import org.apache.doris.nereids.trees.plans.physical.PhysicalHashJoin;
import org.apache.doris.nereids.trees.plans.physical.PhysicalJdbcScan;
import org.apache.doris.nereids.trees.plans.physical.PhysicalLimit;
import org.apache.doris.nereids.trees.plans.physical.PhysicalNestedLoopJoin;
import org.apache.doris.nereids.trees.plans.physical.PhysicalOlapScan;
import org.apache.doris.nereids.trees.plans.physical.PhysicalOneRowRelation;
import org.apache.doris.nereids.trees.plans.physical.PhysicalProject;
import org.apache.doris.nereids.trees.plans.physical.PhysicalQuickSort;
import org.apache.doris.nereids.trees.plans.physical.PhysicalRepeat;
import org.apache.doris.nereids.trees.plans.physical.PhysicalSchemaScan;
import org.apache.doris.nereids.trees.plans.physical.PhysicalStorageLayerAggregate;
import org.apache.doris.nereids.trees.plans.physical.PhysicalTVFRelation;
import org.apache.doris.nereids.trees.plans.physical.PhysicalTopN;
import org.apache.doris.nereids.trees.plans.physical.PhysicalWindow;

public interface GeneratedMemoPatterns extends MemoPatterns {
  default PatternDescriptor<LogicalEmptyRelation> logicalEmptyRelation() {
      return new PatternDescriptor<LogicalEmptyRelation>(
          new TypePattern(LogicalEmptyRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalEsScan> logicalEsScan() {
      return new PatternDescriptor<LogicalEsScan>(
          new TypePattern(LogicalEsScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalFileScan> logicalFileScan() {
      return new PatternDescriptor<LogicalFileScan>(
          new TypePattern(LogicalFileScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalJdbcScan> logicalJdbcScan() {
      return new PatternDescriptor<LogicalJdbcScan>(
          new TypePattern(LogicalJdbcScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalOlapScan> logicalOlapScan() {
      return new PatternDescriptor<LogicalOlapScan>(
          new TypePattern(LogicalOlapScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalOneRowRelation> logicalOneRowRelation() {
      return new PatternDescriptor<LogicalOneRowRelation>(
          new TypePattern(LogicalOneRowRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalSchemaScan> logicalSchemaScan() {
      return new PatternDescriptor<LogicalSchemaScan>(
          new TypePattern(LogicalSchemaScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalTVFRelation> logicalTVFRelation() {
      return new PatternDescriptor<LogicalTVFRelation>(
          new TypePattern(LogicalTVFRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<UnboundOneRowRelation> unboundOneRowRelation() {
      return new PatternDescriptor<UnboundOneRowRelation>(
          new TypePattern(UnboundOneRowRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<UnboundRelation> unboundRelation() {
      return new PatternDescriptor<UnboundRelation>(
          new TypePattern(UnboundRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<UnboundTVFRelation> unboundTVFRelation() {
      return new PatternDescriptor<UnboundTVFRelation>(
          new TypePattern(UnboundTVFRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalAggregate<GroupPlan>> logicalAggregate() {
      return new PatternDescriptor<LogicalAggregate<GroupPlan>>(
          new TypePattern(LogicalAggregate.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalAggregate<C1>>
          logicalAggregate(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalAggregate<C1>>(
          new TypePattern(LogicalAggregate.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalAssertNumRows<GroupPlan>> logicalAssertNumRows() {
      return new PatternDescriptor<LogicalAssertNumRows<GroupPlan>>(
          new TypePattern(LogicalAssertNumRows.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalAssertNumRows<C1>>
          logicalAssertNumRows(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalAssertNumRows<C1>>(
          new TypePattern(LogicalAssertNumRows.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalCTE<GroupPlan>> logicalCTE() {
      return new PatternDescriptor<LogicalCTE<GroupPlan>>(
          new TypePattern(LogicalCTE.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalCTE<C1>>
          logicalCTE(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalCTE<C1>>(
          new TypePattern(LogicalCTE.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalCheckPolicy<GroupPlan>> logicalCheckPolicy() {
      return new PatternDescriptor<LogicalCheckPolicy<GroupPlan>>(
          new TypePattern(LogicalCheckPolicy.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalCheckPolicy<C1>>
          logicalCheckPolicy(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalCheckPolicy<C1>>(
          new TypePattern(LogicalCheckPolicy.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalFilter<GroupPlan>> logicalFilter() {
      return new PatternDescriptor<LogicalFilter<GroupPlan>>(
          new TypePattern(LogicalFilter.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalFilter<C1>>
          logicalFilter(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalFilter<C1>>(
          new TypePattern(LogicalFilter.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalGenerate<GroupPlan>> logicalGenerate() {
      return new PatternDescriptor<LogicalGenerate<GroupPlan>>(
          new TypePattern(LogicalGenerate.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalGenerate<C1>>
          logicalGenerate(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalGenerate<C1>>(
          new TypePattern(LogicalGenerate.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalHaving<GroupPlan>> logicalHaving() {
      return new PatternDescriptor<LogicalHaving<GroupPlan>>(
          new TypePattern(LogicalHaving.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalHaving<C1>>
          logicalHaving(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalHaving<C1>>(
          new TypePattern(LogicalHaving.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalLimit<GroupPlan>> logicalLimit() {
      return new PatternDescriptor<LogicalLimit<GroupPlan>>(
          new TypePattern(LogicalLimit.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalLimit<C1>>
          logicalLimit(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalLimit<C1>>(
          new TypePattern(LogicalLimit.class, child1.pattern),
          defaultPromise()
      );
  }
  
  default PatternDescriptor<LogicalLimit<GroupPlan>> localLogicalLimit() {
      return new PatternDescriptor<LogicalLimit<GroupPlan>>(
          new TypePattern(LogicalLimit.class, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.LOCAL);
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalLimit<C1>>
          localLogicalLimit(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalLimit<C1>>(
          new TypePattern(LogicalLimit.class, child1.pattern),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.LOCAL);
  }
  
  default PatternDescriptor<LogicalLimit<GroupPlan>> globalLogicalLimit() {
      return new PatternDescriptor<LogicalLimit<GroupPlan>>(
          new TypePattern(LogicalLimit.class, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.GLOBAL);
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalLimit<C1>>
          globalLogicalLimit(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalLimit<C1>>(
          new TypePattern(LogicalLimit.class, child1.pattern),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.GLOBAL);
  }
  
  default PatternDescriptor<LogicalLimit<GroupPlan>> originLogicalLimit() {
      return new PatternDescriptor<LogicalLimit<GroupPlan>>(
          new TypePattern(LogicalLimit.class, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.ORIGIN);
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalLimit<C1>>
          originLogicalLimit(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalLimit<C1>>(
          new TypePattern(LogicalLimit.class, child1.pattern),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.ORIGIN);
  }

  default PatternDescriptor<LogicalProject<GroupPlan>> logicalProject() {
      return new PatternDescriptor<LogicalProject<GroupPlan>>(
          new TypePattern(LogicalProject.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalProject<C1>>
          logicalProject(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalProject<C1>>(
          new TypePattern(LogicalProject.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalRepeat<GroupPlan>> logicalRepeat() {
      return new PatternDescriptor<LogicalRepeat<GroupPlan>>(
          new TypePattern(LogicalRepeat.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalRepeat<C1>>
          logicalRepeat(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalRepeat<C1>>(
          new TypePattern(LogicalRepeat.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalSelectHint<GroupPlan>> logicalSelectHint() {
      return new PatternDescriptor<LogicalSelectHint<GroupPlan>>(
          new TypePattern(LogicalSelectHint.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalSelectHint<C1>>
          logicalSelectHint(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalSelectHint<C1>>(
          new TypePattern(LogicalSelectHint.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalSort<GroupPlan>> logicalSort() {
      return new PatternDescriptor<LogicalSort<GroupPlan>>(
          new TypePattern(LogicalSort.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalSort<C1>>
          logicalSort(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalSort<C1>>(
          new TypePattern(LogicalSort.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalSubQueryAlias<GroupPlan>> logicalSubQueryAlias() {
      return new PatternDescriptor<LogicalSubQueryAlias<GroupPlan>>(
          new TypePattern(LogicalSubQueryAlias.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalSubQueryAlias<C1>>
          logicalSubQueryAlias(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalSubQueryAlias<C1>>(
          new TypePattern(LogicalSubQueryAlias.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalTopN<GroupPlan>> logicalTopN() {
      return new PatternDescriptor<LogicalTopN<GroupPlan>>(
          new TypePattern(LogicalTopN.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalTopN<C1>>
          logicalTopN(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalTopN<C1>>(
          new TypePattern(LogicalTopN.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalWindow<GroupPlan>> logicalWindow() {
      return new PatternDescriptor<LogicalWindow<GroupPlan>>(
          new TypePattern(LogicalWindow.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<LogicalWindow<C1>>
          logicalWindow(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<LogicalWindow<C1>>(
          new TypePattern(LogicalWindow.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalApply<GroupPlan, GroupPlan>> logicalApply() {
      return new PatternDescriptor<LogicalApply<GroupPlan, GroupPlan>>(
          new TypePattern(LogicalApply.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalApply<C1, C2>>
          logicalApply(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalApply<C1, C2>>(
          new TypePattern(LogicalApply.class, child1.pattern, child2.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>> logicalJoin() {
      return new PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>>(
          new TypePattern(LogicalJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          logicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      );
  }
  
  default PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>> innerLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>>(
          new TypePattern(LogicalJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.INNER_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          innerLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.INNER_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>> leftOuterLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>>(
          new TypePattern(LogicalJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_OUTER_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          leftOuterLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_OUTER_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>> rightOuterLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>>(
          new TypePattern(LogicalJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_OUTER_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          rightOuterLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_OUTER_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>> fullOuterLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>>(
          new TypePattern(LogicalJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.FULL_OUTER_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          fullOuterLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.FULL_OUTER_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>> leftSemiLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>>(
          new TypePattern(LogicalJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_SEMI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          leftSemiLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_SEMI_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>> rightSemiLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>>(
          new TypePattern(LogicalJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_SEMI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          rightSemiLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_SEMI_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>> leftAntiLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>>(
          new TypePattern(LogicalJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_ANTI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          leftAntiLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_ANTI_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>> rightAntiLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>>(
          new TypePattern(LogicalJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_ANTI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          rightAntiLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_ANTI_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>> crossLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>>(
          new TypePattern(LogicalJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.CROSS_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          crossLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.CROSS_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>> nullAwareLeftAntiLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>>(
          new TypePattern(LogicalJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.NULL_AWARE_LEFT_ANTI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          nullAwareLeftAntiLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.NULL_AWARE_LEFT_ANTI_JOIN);
  }
  
  default PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>> noneLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>>(
          new TypePattern(LogicalJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.NONE);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          noneLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.NONE);
  }
  
  default PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>> broadcastRightLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>>(
          new TypePattern(LogicalJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.BROADCAST_RIGHT);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          broadcastRightLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.BROADCAST_RIGHT);
  }
  
  default PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>> shuffleRightLogicalJoin() {
      return new PatternDescriptor<LogicalJoin<GroupPlan, GroupPlan>>(
          new TypePattern(LogicalJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.SHUFFLE_RIGHT);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<LogicalJoin<C1, C2>>
          shuffleRightLogicalJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<LogicalJoin<C1, C2>>(
          new TypePattern(LogicalJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.SHUFFLE_RIGHT);
  }

  default PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>> usingJoin() {
      return new PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>>(
          new TypePattern(UsingJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          usingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      );
  }
  
  default PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>> innerUsingJoin() {
      return new PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>>(
          new TypePattern(UsingJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.INNER_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          innerUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.INNER_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>> leftOuterUsingJoin() {
      return new PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>>(
          new TypePattern(UsingJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_OUTER_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          leftOuterUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_OUTER_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>> rightOuterUsingJoin() {
      return new PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>>(
          new TypePattern(UsingJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_OUTER_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          rightOuterUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_OUTER_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>> fullOuterUsingJoin() {
      return new PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>>(
          new TypePattern(UsingJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.FULL_OUTER_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          fullOuterUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.FULL_OUTER_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>> leftSemiUsingJoin() {
      return new PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>>(
          new TypePattern(UsingJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_SEMI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          leftSemiUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_SEMI_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>> rightSemiUsingJoin() {
      return new PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>>(
          new TypePattern(UsingJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_SEMI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          rightSemiUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_SEMI_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>> leftAntiUsingJoin() {
      return new PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>>(
          new TypePattern(UsingJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_ANTI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          leftAntiUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.LEFT_ANTI_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>> rightAntiUsingJoin() {
      return new PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>>(
          new TypePattern(UsingJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_ANTI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          rightAntiUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.RIGHT_ANTI_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>> crossUsingJoin() {
      return new PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>>(
          new TypePattern(UsingJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.CROSS_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          crossUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.CROSS_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>> nullAwareLeftAntiUsingJoin() {
      return new PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>>(
          new TypePattern(UsingJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.NULL_AWARE_LEFT_ANTI_JOIN);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          nullAwareLeftAntiUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getJoinType() == JoinType.NULL_AWARE_LEFT_ANTI_JOIN);
  }
  
  default PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>> noneUsingJoin() {
      return new PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>>(
          new TypePattern(UsingJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.NONE);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          noneUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.NONE);
  }
  
  default PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>> broadcastRightUsingJoin() {
      return new PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>>(
          new TypePattern(UsingJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.BROADCAST_RIGHT);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          broadcastRightUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.BROADCAST_RIGHT);
  }
  
  default PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>> shuffleRightUsingJoin() {
      return new PatternDescriptor<UsingJoin<GroupPlan, GroupPlan>>(
          new TypePattern(UsingJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.SHUFFLE_RIGHT);
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<UsingJoin<C1, C2>>
          shuffleRightUsingJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<UsingJoin<C1, C2>>(
          new TypePattern(UsingJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      ).when(p -> p.getHint() == JoinHint.SHUFFLE_RIGHT);
  }

  default PatternDescriptor<PhysicalEmptyRelation> physicalEmptyRelation() {
      return new PatternDescriptor<PhysicalEmptyRelation>(
          new TypePattern(PhysicalEmptyRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalEsScan> physicalEsScan() {
      return new PatternDescriptor<PhysicalEsScan>(
          new TypePattern(PhysicalEsScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalFileScan> physicalFileScan() {
      return new PatternDescriptor<PhysicalFileScan>(
          new TypePattern(PhysicalFileScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalJdbcScan> physicalJdbcScan() {
      return new PatternDescriptor<PhysicalJdbcScan>(
          new TypePattern(PhysicalJdbcScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalOlapScan> physicalOlapScan() {
      return new PatternDescriptor<PhysicalOlapScan>(
          new TypePattern(PhysicalOlapScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalOneRowRelation> physicalOneRowRelation() {
      return new PatternDescriptor<PhysicalOneRowRelation>(
          new TypePattern(PhysicalOneRowRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalSchemaScan> physicalSchemaScan() {
      return new PatternDescriptor<PhysicalSchemaScan>(
          new TypePattern(PhysicalSchemaScan.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalStorageLayerAggregate> physicalStorageLayerAggregate() {
      return new PatternDescriptor<PhysicalStorageLayerAggregate>(
          new TypePattern(PhysicalStorageLayerAggregate.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalTVFRelation> physicalTVFRelation() {
      return new PatternDescriptor<PhysicalTVFRelation>(
          new TypePattern(PhysicalTVFRelation.class),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalAssertNumRows<GroupPlan>> physicalAssertNumRows() {
      return new PatternDescriptor<PhysicalAssertNumRows<GroupPlan>>(
          new TypePattern(PhysicalAssertNumRows.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalAssertNumRows<C1>>
          physicalAssertNumRows(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalAssertNumRows<C1>>(
          new TypePattern(PhysicalAssertNumRows.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalDistribute<GroupPlan>> physicalDistribute() {
      return new PatternDescriptor<PhysicalDistribute<GroupPlan>>(
          new TypePattern(PhysicalDistribute.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalDistribute<C1>>
          physicalDistribute(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalDistribute<C1>>(
          new TypePattern(PhysicalDistribute.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalFilter<GroupPlan>> physicalFilter() {
      return new PatternDescriptor<PhysicalFilter<GroupPlan>>(
          new TypePattern(PhysicalFilter.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalFilter<C1>>
          physicalFilter(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalFilter<C1>>(
          new TypePattern(PhysicalFilter.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalGenerate<GroupPlan>> physicalGenerate() {
      return new PatternDescriptor<PhysicalGenerate<GroupPlan>>(
          new TypePattern(PhysicalGenerate.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalGenerate<C1>>
          physicalGenerate(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalGenerate<C1>>(
          new TypePattern(PhysicalGenerate.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalHashAggregate<GroupPlan>> physicalHashAggregate() {
      return new PatternDescriptor<PhysicalHashAggregate<GroupPlan>>(
          new TypePattern(PhysicalHashAggregate.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalHashAggregate<C1>>
          physicalHashAggregate(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalHashAggregate<C1>>(
          new TypePattern(PhysicalHashAggregate.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalLimit<GroupPlan>> physicalLimit() {
      return new PatternDescriptor<PhysicalLimit<GroupPlan>>(
          new TypePattern(PhysicalLimit.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalLimit<C1>>
          physicalLimit(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalLimit<C1>>(
          new TypePattern(PhysicalLimit.class, child1.pattern),
          defaultPromise()
      );
  }
  
  default PatternDescriptor<PhysicalLimit<GroupPlan>> localPhysicalLimit() {
      return new PatternDescriptor<PhysicalLimit<GroupPlan>>(
          new TypePattern(PhysicalLimit.class, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.LOCAL);
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalLimit<C1>>
          localPhysicalLimit(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalLimit<C1>>(
          new TypePattern(PhysicalLimit.class, child1.pattern),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.LOCAL);
  }
  
  default PatternDescriptor<PhysicalLimit<GroupPlan>> globalPhysicalLimit() {
      return new PatternDescriptor<PhysicalLimit<GroupPlan>>(
          new TypePattern(PhysicalLimit.class, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.GLOBAL);
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalLimit<C1>>
          globalPhysicalLimit(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalLimit<C1>>(
          new TypePattern(PhysicalLimit.class, child1.pattern),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.GLOBAL);
  }
  
  default PatternDescriptor<PhysicalLimit<GroupPlan>> originPhysicalLimit() {
      return new PatternDescriptor<PhysicalLimit<GroupPlan>>(
          new TypePattern(PhysicalLimit.class, Pattern.GROUP),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.ORIGIN);
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalLimit<C1>>
          originPhysicalLimit(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalLimit<C1>>(
          new TypePattern(PhysicalLimit.class, child1.pattern),
          defaultPromise()
      ).when(p -> p.getPhase() == LimitPhase.ORIGIN);
  }

  default PatternDescriptor<PhysicalProject<GroupPlan>> physicalProject() {
      return new PatternDescriptor<PhysicalProject<GroupPlan>>(
          new TypePattern(PhysicalProject.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalProject<C1>>
          physicalProject(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalProject<C1>>(
          new TypePattern(PhysicalProject.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalQuickSort<GroupPlan>> physicalQuickSort() {
      return new PatternDescriptor<PhysicalQuickSort<GroupPlan>>(
          new TypePattern(PhysicalQuickSort.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalQuickSort<C1>>
          physicalQuickSort(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalQuickSort<C1>>(
          new TypePattern(PhysicalQuickSort.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalRepeat<GroupPlan>> physicalRepeat() {
      return new PatternDescriptor<PhysicalRepeat<GroupPlan>>(
          new TypePattern(PhysicalRepeat.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalRepeat<C1>>
          physicalRepeat(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalRepeat<C1>>(
          new TypePattern(PhysicalRepeat.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalTopN<GroupPlan>> physicalTopN() {
      return new PatternDescriptor<PhysicalTopN<GroupPlan>>(
          new TypePattern(PhysicalTopN.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalTopN<C1>>
          physicalTopN(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalTopN<C1>>(
          new TypePattern(PhysicalTopN.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalWindow<GroupPlan>> physicalWindow() {
      return new PatternDescriptor<PhysicalWindow<GroupPlan>>(
          new TypePattern(PhysicalWindow.class, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan>
  PatternDescriptor<PhysicalWindow<C1>>
          physicalWindow(PatternDescriptor<C1> child1) {
      return new PatternDescriptor<PhysicalWindow<C1>>(
          new TypePattern(PhysicalWindow.class, child1.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalHashJoin<GroupPlan, GroupPlan>> physicalHashJoin() {
      return new PatternDescriptor<PhysicalHashJoin<GroupPlan, GroupPlan>>(
          new TypePattern(PhysicalHashJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<PhysicalHashJoin<C1, C2>>
          physicalHashJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<PhysicalHashJoin<C1, C2>>(
          new TypePattern(PhysicalHashJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      );
  }

  default PatternDescriptor<PhysicalNestedLoopJoin<GroupPlan, GroupPlan>> physicalNestedLoopJoin() {
      return new PatternDescriptor<PhysicalNestedLoopJoin<GroupPlan, GroupPlan>>(
          new TypePattern(PhysicalNestedLoopJoin.class, Pattern.GROUP, Pattern.GROUP),
          defaultPromise()
      );
  }
  
  default <C1 extends Plan, C2 extends Plan>
  PatternDescriptor<PhysicalNestedLoopJoin<C1, C2>>
          physicalNestedLoopJoin(PatternDescriptor<C1> child1, PatternDescriptor<C2> child2) {
      return new PatternDescriptor<PhysicalNestedLoopJoin<C1, C2>>(
          new TypePattern(PhysicalNestedLoopJoin.class, child1.pattern, child2.pattern),
          defaultPromise()
      );
  }
}
