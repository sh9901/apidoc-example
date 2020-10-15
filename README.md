#内容
本应用目的是提供一个集成了Swagger、Java Bean Validation的demo，用于展示如何集成Swagger自动生成格式良好、信息完备的接口文档，以便于团队之间的
协作。
- 为了在文档中展示充分的信息以描述接口的行为，开发者需要在Controller，Entity上使用swagger-annotations中的注解对接口做充分的描述。
- 在接口文档描述的同时，开发者应该利用Java Bean Validation的机制对请求参数做等价的校验。

##集成swagger
```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>
```
```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
```
##配置SwaggerConfig
应用启动之后可以通过http://host:port/swagger-ui.html访问调试页面或者http://host:port/v2/api-docs访问json版本接口文档
```java
@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot使用Swagger构建api文档")
                .description("demo")
                .version("1.0")
                .build();
    }
}
```
##集成knife4j[更加友好的在线调试](https://doc.xiaominfo.com/guide/useful.html)
应用启动后可以通过http://host:port/doc.html访问接口调试页面
```xml
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>knife4j-spring-boot-starter</artifactId>
    <version>2.0.5</version>
</dependency>
```
##集成Java Bean Validation
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```
##集成swagger-annotations
```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-annotations</artifactId>
    <version>1.6.1</version>
</dependency>
```
##SpringFox Bean Validators for Swagger Documentation
```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-bean-validators</artifactId>
    <version>2.9.2</version>
</dependency>
```
##代码示例
###PathVariable
```java
@ApiOperation(value = "按用户ID查询用户详情")
@ApiImplicitParam(name = "userId", example = "100")
@GetMapping("/user/{userId}")
UserDetailResponse queryUser(@Positive @PathVariable int userId) {
    return userService.queryUserDetail(userId);
}

```
###RequestParam
```java
@ApiOperation(value = "搜索用户")
@GetMapping("/user/search")
@ApiImplicitParams({
        @ApiImplicitParam(name = "userName", value = "用户名", example = "ABC"),
        @ApiImplicitParam(name = "gender", value = "性别", allowableValues = "0,1", example = "1"),
        @ApiImplicitParam(name = "minAge", value = "筛选年龄大于", required = true, example = "18", dataType = "int"),
        //dataType不指定会影响swagger-doc中type,maxLength/maximum,x-example的正确生成
        @ApiImplicitParam(name = "maxAge", value = "筛选年龄小于", required = true, example = "60"),
        @ApiImplicitParam(name = "skinColor", value = "筛选肤色", required = true, allowableValues = "yellow,white,black", example = "black")
})
List<UserDetailResponse> searchUsers(
        @RequestParam @CheckCase(CaseMode.UPPER) String userName,
        @RequestParam(required = false) @Min(value = 0, message = "性别最小取值0") @Max(value = 1, message = "性别最大取值1") int gender,
        @RequestParam(value = "minAge") @Min(18) int ageMin,
        @RequestParam(value = "maxAge") @Max(60) @NotNull int ageMax,
        @RequestParam @NotEmpty String skinColor) {
    return userService.searchUsers(userName, gender, ageMin, ageMax, skinColor);
}
```
###RequestBody
```java
@Data
@ApiModel(description = "用户筛选请求")
public class UserFilterRequest {
    @Min(value = 0, message = "性别最小取值为0-女")
    @Max(value = 1, message = "性别最大取值为1-男")
    @ApiModelProperty(required = true, example = "1", allowableValues = "0,1")
    private int gender;

    @Min(value = 18, message = "最小年龄不能小于18")
    @Max(value = 60, message = "最大年龄不能大于60")
    private int age;

    /**
     * 类似枚举值validation需要自定义
     * 应该用enum类型的枚举值
     */
    @ApiModelProperty(required = true, example = "yellow", allowableValues = "yellow,white,black")
    @NotNull(message = "查询条件肤色不能为空")
    private String skinColor;


    /**
     * enum类型不需要自定义check
     * :@CheckEnum(anyOf = {RoleEnum.ADMIN, RoleEnum.MANAGER, RoleEnum.OPERATOR})
     * enum 类型不需要填写allowableValues,api-doc中可以自动获取
     */
    @ApiModelProperty(required = true, example = "OPERATOR")
    @NotNull(message = "用户角色不能为空")
    private RoleEnum roleEnum;

    @NotNull(message = "筛选用户名不可以为空")
    @ApiModelProperty(required = true)
    @Size(min = 2, max = 8, message = "用户名长度限制[2-8]")
    @CheckCase(value = CaseMode.UPPER, message = "userName需要大写")
    private String userName;
}
```
##参考链接
[Complete Guide to Validation With Spring Boot](https://reflectoring.io/bean-validation-with-spring-boot/)

[Available validation annotations](https://docs.jboss.org/hibernate/beanvalidation/spec/2.0/api/javax/validation/constraints/package-summary.html)
 
[Springboot Swagger2注解使用](https://www.cnblogs.com/jstarseven/p/11458919.html)