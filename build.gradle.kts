plugins {
    java
    signing
    `maven-publish`
    id("io.github.gradle-nexus.publish-plugin") version "2.0.0"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "com.legendaryrealms.LegendaryGuild"
version = "5.1.8.5"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://jitpack.io")
    maven("https://repo.rosewooddev.io/repository/public/")
    maven("https://repo.codemc.io/repository/maven-public/")
    maven("https://repo.codemc.io/repository/maven-snapshots/")
    maven("https://nexus.phoenixdevt.fr/repository/maven-public/")
    maven("https://repo.dmulloy2.net/repository/public/")
}

dependencies {
    compileOnly("mysql:mysql-connector-java:5.1.48")
    compileOnly("org.spigotmc:spigot-api:1.20-R0.1-SNAPSHOT")
    compileOnly("org.xerial:sqlite-jdbc:3.28.0")
    compileOnly("me.clip:placeholderapi:2.11.6")
    compileOnly("com.github.MilkBowl:VaultAPI:1.7")
    compileOnly("org.black_ixx:playerpoints:3.2.5")
    compileOnly(files("src/depend/AttributePlus-3.3.2.0.jar"))
    compileOnly(files("src/depend/AttributePlus-2.3.7.jar"))
    compileOnly(files("src/depend/SX-Attribute-2.0.3.jar"))
    compileOnly("io.lumine:MythicLib-dist:1.5.2-SNAPSHOT")
    compileOnly("com.comphenix.protocol:ProtocolLib:5.1.0")
    
    implementation("com.zaxxer:HikariCP:3.4.5")
    implementation("org.bstats:bstats-bukkit:3.0.2")
    implementation("de.tr7zw:item-nbt-api:2.14.0")
    implementation("org.jetbrains:annotations:21.0.0")
}
val targetJavaVersion = 8
java {
    val javaVersion = JavaVersion.toVersion(targetJavaVersion)
    if (JavaVersion.current() < javaVersion) {
        toolchain.languageVersion.set(JavaLanguageVersion.of(targetJavaVersion))
    }
    withSourcesJar()
    withJavadocJar()
}
tasks {
    shadowJar {
        mapOf(
            "org.intellij.lang.annotations" to "annotations.intellij",
            "org.jetbrains.annotations" to "annotations.jetbrains",
            "de.tr7zw.changeme.nbtapi" to "nbtapi",
            "com.zaxxer.hikari" to "hikari",
            "org.bstats" to "bstats",
            "org.wesjd" to "wesjd",
        ).forEach { (original, target) ->
            relocate(original, "com.legendaryrealms.LegendaryGuild.lib.$target")
        }
    }
    build {
        dependsOn(shadowJar)
    }
    withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
        if (targetJavaVersion >= 10 || JavaVersion.current().isJava10Compatible) {
            options.release.set(targetJavaVersion)
        }
    }
    javadoc {
        (options as StandardJavadocDocletOptions).apply {
            links("https://docs.oracle.com/javase/8/docs/api/")
            links("https://hub.spigotmc.org/javadocs/spigot/")

            locale("zh_CN")
            encoding("UTF-8")
            docEncoding("UTF-8")
            addBooleanOption("keywords", true)
            addBooleanOption("Xdoclint:none", true)
        }
    }
}
publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components.getByName("java"))
            groupId = project.group.toString()
            artifactId = rootProject.name
            version = project.version.toString()

            pom {
                name.set(artifactId)
                description.set("Minecraft Guild Plugin")
                url.set("https://github.com/MrXiaoM/LegendaryGuild")
                licenses {
                    license {
                        name.set("No License")
                        url.set("https://github.com/MrXiaoM/LegendaryGuild/blob/main/LICENSE")
                    }
                }
                developers {
                    developer {
                        name.set("MrXiaoM")
                        email.set("mrxiaom@qq.com")
                    }
                }
                scm {
                    url.set("https://github.com/MrXiaoM/LegendaryGuild")
                    connection.set("scm:git:https://github.com/MrXiaoM/LegendaryGuild.git")
                    developerConnection.set("scm:git:https://github.com/MrXiaoM/LegendaryGuild.git")
                }
            }
        }
    }
}
signing {
    val signingKey = findProperty("signingKey")?.toString()
    val signingPassword = findProperty("signingPassword")?.toString()
    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(signingKey, signingPassword)
        sign(publishing.publications.getByName("maven"))
    }
}
nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
            username.set(findProperty("MAVEN_USERNAME")?.toString())
            password.set(findProperty("MAVEN_PASSWORD")?.toString())
        }
    }
}
