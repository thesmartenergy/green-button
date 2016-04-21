/*
 * Copyright 2016 ITEA 12004 SEAS Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.thesmartenergy.gb.entities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author maxime.lefrancois
 */
@ApplicationScoped
public class Queries {

    private static final Logger LOG = Logger.getLogger(Queries.class.getSimpleName());

    private final String base = "http://w3id.org/seas/green-button/query/";
    
    private final Map<String, File> queries = new HashMap<>();
    
    @Inject
    ServletContext context;

    @PostConstruct
    public void initialize() {
        try {
            String dir = context.getRealPath("/WEB-INF/classes/");
            LOG.info(dir);
            LOG.info(context.getRealPath("/WEB-INF/classes"));
            LOG.info(context.getClassLoader().getResource("/").toString());
            LOG.info(context.getClassLoader().getResource("/").getPath());
            LOG.info(context.getClassLoader().getResource("/").toURI().toString());

            File ontoDir = new File( dir + "/query/" );
            for(File queryFile : ontoDir.listFiles()) {
                String queryFileName = queryFile.getName();
                String queryName = FilenameUtils.removeExtension(queryFileName);
                queries.put( base + queryFileName, queryFile);
                queries.put( base + queryName, queryFile);
            } 
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "error while initializing app ", ex);
            throw new RuntimeException("error while initializing app ", ex);
        }
    }

    public Map<String, File> getQueries() {
        return queries;
    }
    
    public String getBase() {
        return base;
    }
    
}
