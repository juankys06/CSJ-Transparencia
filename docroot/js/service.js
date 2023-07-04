Liferay.Service.register("Liferay.Service.ley_transparencia", "com.co.csj.service.service", "ley_transparencia-portlet");

Liferay.Service.registerClass(
	Liferay.Service.ley_transparencia, "servicioapileytrans",
	{
		getDepartamentos: true,
		getMunicipios: true,
		getEntidadDepartamento: true,
		getDespachosFiltro: true,
		getFuncionariosDespacho: true,
		getAnhios: true
	}
);