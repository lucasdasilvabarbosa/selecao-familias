package br.selecao.familias.resources;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("v1")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        try {
            Class jsonProvider = Class.forName("org.glassfish.jersey.jackson.JacksonFeature");
            resources.add(jsonProvider);
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao adicionar o provider do Json");
            ex.printStackTrace();
        }
        addRestResourceClasses(resources);
        addMyRestResourceClasses(resources);
        return resources;
    }

    public ApplicationConfig() {
        BeanConfig config = new BeanConfig();
        config.setTitle("Seleção de Familias");
        config.setDescription("");
        config.setVersion("1.0-BETA");
        config.setBasePath("/selecao-familias/v1");
        config.setSchemes(new String[]{"http"});
        config.setResourcePackage("br.selecao.familias.resources");
        config.setScan(true);
    }

    private void addMyRestResourceClasses(Set<Class<?>> resources) {
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(FamiliasResouces.class);
    }
}
