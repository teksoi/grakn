#
# Copyright (C) 2020 Grakn Labs
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU Affero General Public License as
# published by the Free Software Foundation, either version 3 of the
# License, or (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Affero General Public License for more details.
#
# You should have received a copy of the GNU Affero General Public License
# along with this program.  If not, see <https://www.gnu.org/licenses/>.
#

load("@graknlabs_dependencies//tool/checkstyle:rules.bzl", "checkstyle_test")

java_test(
    name = "grakn-client-it",
    size = "large",
    srcs = ["GraknClientIT.java"],
    classpath_resources = [
        "//test/resources:logback-test",
        "//test/resources:cassandra-embedded",
        "//server:conf/grakn.properties",
    ],
    test_class = "grakn.core.server.GraknClientIT",
    deps = [
        # Package dependencies
        "@graknlabs_client_java//:client-java",

        # Internal dependencies
        "//kb/server",
        "//kb/concept/api",
        "//test/rule:grakn-test-server",

        # External depencies from @graknlabs
        "@graknlabs_graql//java:graql",

        # External depencncies from Maven
        "@maven//:org_hamcrest_hamcrest_library",
        "@maven//:org_slf4j_slf4j_api",
        "@maven//:com_google_guava_guava",
    ],
)



java_test(
    name = "validator-it",
    size = "medium",
    srcs = ["ValidatorIT.java"],
    classpath_resources = ["//test/resources:logback-test"],
    test_class = "grakn.core.server.ValidatorIT",
    deps = [
        "//common:common",
        "@maven//:org_hamcrest_hamcrest_library",
        "//kb/server",
        "//kb/concept/api",
        "//test/rule:grakn-test-server",
        "@graknlabs_graql//java:graql",
    ],
)

java_test(
    name = "validate-global-rules-it",
    size = "medium",
    srcs = ["ValidateGlobalRulesIT.java"],
    classpath_resources = ["//test/resources:logback-test"],
    test_class = "grakn.core.server.ValidateGlobalRulesIT",
    deps = [
        "//concept/impl:impl",
        "//kb/server",
        "//kb/concept/api",
        "//server",
        "//test/rule:grakn-test-server",
        "//test/integration/util:concept-downcasting",
    ],
)

java_test(
    name = "rule-validation-it",
    size = "large",
    srcs = ["RuleValidationIT.java"],
    classpath_resources = ["//test/resources:logback-test"],
    test_class = "grakn.core.server.RuleValidationIT",
    deps = [
        "//common:common",
        "//core",
        "@maven//:com_google_guava_guava",
        "@maven//:org_hamcrest_hamcrest_library",
        "//kb/server",
        "//kb/concept/api",
        "//graql/reasoner",
        "//test/rule:grakn-test-server",
        "@graknlabs_graql//java:graql",
    ],
)


checkstyle_test(
    name = "checkstyle",
    targets = [
        ":grakn-client-it",
        ":validator-it",
        ":validate-global-rules-it",
        ":rule-validation-it",
    ],
)
