
package graduation.design.colleges.schoolroom.help.jcaptcha;

import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-3-22 下午3:38
 * <p>Version: 1.0
 * 提供了判断仓库中是否有相应的验证码存在。
 */
public class MyManageableImageCaptchaService extends DefaultManageableImageCaptchaService {

    public MyManageableImageCaptchaService(com.octo.captcha.service.captchastore.CaptchaStore captchaStore, com.octo.captcha.engine.CaptchaEngine captchaEngine, int minGuarantedStorageDelayInSeconds, int maxCaptchaStoreSize, int captchaStoreLoadBeforeGarbageCollection) {
        super(captchaStore, captchaEngine, minGuarantedStorageDelayInSeconds, maxCaptchaStoreSize, captchaStoreLoadBeforeGarbageCollection);
    }

    public boolean hasCapcha(String id, String userCaptchaResponse) {
        return store.getCaptcha(id).validateResponse(userCaptchaResponse);
    }
}
