import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {HttpClientService} from "./http-client.service";

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [],
  providers: [HttpClientService]
})
export class CoreModule { }
